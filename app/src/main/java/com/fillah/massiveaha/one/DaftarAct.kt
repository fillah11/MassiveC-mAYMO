package com.fillah.massiveaha.one

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DaftarAct : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBinding

    private lateinit var auth : FirebaseAuth

    private lateinit var progressDialog : ProgressDialog

    private lateinit var email : String
    private lateinit var username :String
    private lateinit var password :String
    private lateinit var konfirmasiPass :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.email.text.toString()
        username = binding.username.text.toString()
        password = binding.password.text.toString()
        konfirmasiPass = binding.confirmPass.text.toString()

        auth = FirebaseAuth.getInstance()

        //button back
        binding.back.setOnClickListener {
            finish()
        }

        //check box click checker
        binding.chkDaftar.setOnCheckedChangeListener { _, isChecked ->
            binding.btnDaftar.isEnabled = isChecked
            binding.btnDaftar.isClickable = isChecked
        }

        //set progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Creating an account")
        progressDialog.setCanceledOnTouchOutside(false)

        //click button daftar
        binding.btnDaftar.setOnClickListener {

            email = binding.email.text.toString()
            username = binding.username.text.toString()
            password = binding.password.text.toString()
            konfirmasiPass = binding.confirmPass.text.toString()

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

            //validasi username kosong
            if (username.isEmpty()){
                binding.username.error = "username harus diisi!"
                binding.username.requestFocus()
                return@setOnClickListener
            }

            //validasi password kosong
            if (password.isEmpty()){
                binding.password.error = "password harus diisi!"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            //validasi panjang password
            if (password.length<6){
                binding.password.error = "password minimal 6 karakter!"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            //validasi konfirmasi password kosong
            if (konfirmasiPass.isEmpty()){
                binding.confirmPass.error = "password harus diisi!"
                binding.confirmPass.requestFocus()
                return@setOnClickListener
            }

            //validasi konfirmasi password
            if (konfirmasiPass != password){
                binding.confirmPass.error = "password tidak sama!"
                binding.confirmPass.requestFocus()
                return@setOnClickListener
            }

            //lolos validasi, lakukan proses
            firebaseRegister()

        }
    }

    private fun firebaseRegister(){

        email = binding.email.text.toString()
        password = binding.password.text.toString()

        //show progress dialog
        progressDialog.show()

        //create account
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //if register success
                progressDialog.dismiss()

                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()

                //insert data to firestore
                insertData()

                //continue to activity
                val intent = Intent(this, WelcomeAct::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            .addOnFailureListener{
                //if register failed
                progressDialog.dismiss()
                Toast.makeText(this, "Register failed!. ${it.message}", Toast.LENGTH_LONG).show()
            }


    }

    private fun insertData() {

        email = binding.email.text.toString()
        username = binding.username.text.toString()

        // init firestore
        val firestore = Firebase.firestore

        // value yang mau ditambahkan ke db
        val user = hashMapOf(
            "email" to email,
            "username" to username,
            "intro" to true,
            "template" to false,
            "aset" to 0,
            "pendapatan" to 0,
            "pokok" to 0,
            "aset_pokok" to 0,
            "fleksibel" to 0,
            "aset_fleksibel" to 0,
            "investasi" to 0,
            "aset_investasi" to 0
        )

        //add data to db
        firestore.collection("users")
            .document(email).set(user)
            .addOnSuccessListener {
                println("Success! Document successfully added to firestore with email: $email")
            }
            .addOnFailureListener{
                println("Error adding document")
            }

    }
}