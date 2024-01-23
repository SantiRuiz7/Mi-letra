package com.santidevs.reconocimientodetexto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btnIrDos: ImageButton = findViewById(R.id.btn_capture)

        btnIrDos.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnScrolling: ImageButton = findViewById(R.id.btn_search)

        btnScrolling.setOnClickListener {

            val intent = Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
        }

    }
}