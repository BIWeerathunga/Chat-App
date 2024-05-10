package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth //initialize firebase authentication
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()


        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.email_editText)
        edtPassword = findViewById(R.id.password_editText)
        btnLogin = findViewById(R.id.button1)
        btnSignUp = findViewById(R.id.button2)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email, password);
        }
    }
    private fun login(email:String,password:String ){
      //logic for login user
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@Login,MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login,"User doesn't exist",Toast.LENGTH_SHORT).show()
                }
            }

    }


    }
