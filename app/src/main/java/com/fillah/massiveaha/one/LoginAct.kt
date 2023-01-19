package com.fillah.massiveaha.one

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginAct : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    private lateinit var auth : FirebaseAuth

    private lateinit var progressDialog : ProgressDialog

    private lateinit var email : String
    private lateinit var password :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Logging in")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase
        auth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this, DaftarAct::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {

            email = binding.email.text.toString()
            password = binding.password.text.toString()

            //validasi email kosong
            if (email.isEmpty()){
                binding.email.error = "email harus diisi!"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            //validasi apakah input adalah email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.email.error = "email tidak valid!"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            //validasi password kosong
            if (password.isEmpty()){
                binding.password.error = "password harus diisi!"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            //lolos cek validasi
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        progressDialog.show()
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //if login success
                progressDialog.dismiss()

                Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show()

                //open main activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener {
                //if login failed
                progressDialog.dismiss()

                Toast.makeText(this, "Login failled. $it", Toast.LENGTH_LONG).show()
            }
    }
}