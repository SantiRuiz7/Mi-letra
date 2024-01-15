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
            // Crea un Intent para iniciar la nueva actividad
            val intent = Intent(this, MainActivity::class.java)

            // Inicia la nueva actividad
            startActivity(intent)
        }

    }
}