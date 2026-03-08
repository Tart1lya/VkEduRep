package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editText: EditText = findViewById(R.id.editTextText)
        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("TEXT", editText.text.toString())
            }
            startActivity(intent)
        }

        button2.setOnClickListener {
            if (validatePhoneNumber(editText.text.toString())) {
                val callIntent = Intent(Intent.ACTION_DIAL, "tel:${editText.text}".toUri())
                startActivity(callIntent)
            } else {
                Toast.makeText(this, "Неверный формат", Toast.LENGTH_SHORT).show()
            }

        }

        button3.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, editText.text)
            }
            this.startActivity(Intent.createChooser(intent, title))
        }

    }

    fun validatePhoneNumber(phone: String): Boolean {
        val pattern = Regex("^\\+?[0-9]{10,15}$")
        return pattern.matches(phone.replace("\\s|-|\\(|\\)".toRegex(), ""))
    }
}