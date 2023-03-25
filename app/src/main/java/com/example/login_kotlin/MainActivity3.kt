package com.example.login_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main3.emailid

class MainActivity3 : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        firebaseAuth = FirebaseAuth.getInstance()

        sign.setOnClickListener{
            val mail2 = emailid.text.toString()
            val epass = pass2.text.toString()
            val cpass = confpass.text.toString()

            if (mail2.isNotEmpty() && epass.isNotEmpty() && cpass.isNotEmpty())
            {
                if (epass == cpass)
                {
                    firebaseAuth.signInWithEmailAndPassword(mail2,epass).addOnCompleteListener{
                        if (it.isSuccessful)
                        {
                            val intent = Intent(this,MainActivity2::class.java)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else
                {
                    Toast.makeText(this,"Password doesnt match reenter password",Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this,"Empty fields are not allowed",Toast.LENGTH_SHORT).show()
            }
        }


        text.setOnClickListener{
            val intent2 = Intent(this,MainActivity2::class.java)
        }
    }
}