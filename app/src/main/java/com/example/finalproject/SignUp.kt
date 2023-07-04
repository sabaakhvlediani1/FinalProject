package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class SignUp : AppCompatActivity() {

    private lateinit var signUpEmailEditText : EditText
    private lateinit var signUpPasswordEditText : EditText
    private lateinit var signUpRepeatPasswordEditText : EditText
    private lateinit var registerButton : Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        listeners()
        init()
    }

    private fun listeners() {
        auth = FirebaseAuth.getInstance()
        registerButton.setOnClickListener {
            if (signUpEmailEditText.text.toString().isNotEmpty()  || signUpPasswordEditText.text.toString().isNotEmpty()  ||
                signUpRepeatPasswordEditText.text.toString().isNotEmpty()
            ) {
                Toast.makeText(this, "SignUp is Success!", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Email format is not Correct", Toast.LENGTH_LONG).show()
            }
            signUp()
        }
    }

    private fun signUp() {
        val email: String = signUpEmailEditText.text.toString()
        val password: String = signUpPasswordEditText.text.toString()
        val repeatPassword: String = signUpRepeatPasswordEditText.text.toString()


        if (email.isNotEmpty() &&
            password.isNotEmpty() && repeatPassword.isNotEmpty()
        ) {
            if (password == repeatPassword) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SignUp", "createUserWithEmail:success")
                            val user = auth.currentUser
                            startActivity(Intent(this, MainActivity::class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("SignUp", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }



    private fun init(){
        signUpEmailEditText = findViewById(R.id.signUpEmailEditText)
        signUpPasswordEditText = findViewById(R.id.signUpPasswordEditText)
        signUpRepeatPasswordEditText = findViewById(R.id.signUpRepeatPasswordEditText)
        registerButton = findViewById(R.id.registerButton)
    }
}