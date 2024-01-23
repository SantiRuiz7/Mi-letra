package com.santidevs.reconocimientodetexto

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.santidevs.reconocimientodetexto.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wordsA: TextView = findViewById(R.id.wordsA)
        val showCardA: Button = findViewById(R.id.a)

        val wordsB: TextView = findViewById(R.id.wordsB)
        val showCardB: Button = findViewById(R.id.b)

        val wordsC: TextView = findViewById(R.id.wordsC)
        val showCardC: Button = findViewById(R.id.c)

        setSupportActionBar(binding.toolbar)
        binding.toolbarLayout.title = title

        // Click listener para el FAB
        binding.fab.setOnClickListener {


        }


        showCardA.setOnClickListener {

            if (wordsA.visibility == View.INVISIBLE || wordsA.visibility == View.GONE) {
                wordsA.visibility = View.VISIBLE
            } else {
                wordsA.visibility = View.INVISIBLE
            }
        }
        showCardB.setOnClickListener {

            if (wordsB.visibility == View.INVISIBLE || wordsA.visibility == View.GONE) {
                wordsB.visibility = View.VISIBLE
            } else {
                wordsB.visibility = View.INVISIBLE
            }
        }
        showCardC.setOnClickListener {

            if (wordsC.visibility == View.INVISIBLE || wordsC.visibility == View.GONE) {
                wordsC.visibility = View.VISIBLE
            } else {
                wordsC.visibility = View.INVISIBLE
            }
        }
    }
}
