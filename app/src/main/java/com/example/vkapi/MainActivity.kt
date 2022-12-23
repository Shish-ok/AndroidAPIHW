package com.example.vkapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var idForm: EditText
    private lateinit var idButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        idForm = findViewById(R.id.idInput)
        idButton = findViewById(R.id.findBut)
    }

    fun onClickIDButton(view: View) {
        val userID = idForm.text.toString()

        if (userID.isNotEmpty()) {
            val intent = Intent(this, AlbumsActivity::class.java)
            intent.putExtra("user_id", userID)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "Empty ID form!", Toast.LENGTH_SHORT).show()
        }
    }
}