package edu.uncc.culinarycompass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        supportActionBar?.hide()

        val signUpBtn = findViewById<Button>(R.id.signupbtn)
        signUpBtn.setOnClickListener {
            var intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val backArrowBtn = findViewById<Button>(R.id.myArrowBtn)
        backArrowBtn.setOnClickListener {
            var intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}