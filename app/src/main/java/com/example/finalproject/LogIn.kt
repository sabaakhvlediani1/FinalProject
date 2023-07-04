package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText : EditText
    private lateinit var logInButton : Button
    private lateinit var registerPageButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        init()
        listeners()
    }

    private fun listeners() {
        logInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                return@setOnClickListener
            }
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d("Sign In", "signInWithEmail:success")
//                        val user = auth.currentUser
//                        startActivity(Intent(this, MainActivity::class.java))
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.d("Sign in", "signInWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            baseContext, "Authentication failed.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//
//                    }
//
//                }
            startActivity(Intent(this, MainActivity::class.java))


        }

        registerPageButton.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }

    }


    private fun init(){
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        logInButton = findViewById(R.id.logInButton)
        registerPageButton = findViewById(R.id.registerPageButton)
    }


}