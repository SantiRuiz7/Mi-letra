package com.santidevs.reconocimientodetexto

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.santidevs.reconocimientodetexto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    private lateinit var binding: ActivityMainBinding

    private val requestImageCapture = 1

    private var imageBitmap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {

            captureImage.setOnClickListener {

                takeImage()

                textView.text = ""

            }

            detectTextImageBtn.setOnClickListener {

                processImage()

            }

        }

    }

    private fun processImage() {

        if (imageBitmap != null) {

            val image = imageBitmap?.let {

                InputImage.fromBitmap(it, 0)
            }

            image?.let {

                recognizer.process(it)
                    .addOnSuccessListener { result ->
                        if (result.text.isEmpty()) {
                            // No hay texto reconocido
                            Toast.makeText(this, "No se encontró texto en la imagen", Toast.LENGTH_SHORT).show()
                        } else {
                            // Hay texto reconocido, actualiza el TextView
                            binding.textView.text = result.text
                        }
                    }
                    .addOnFailureListener {

                        Toast.makeText(this, "Nothing to show", Toast.LENGTH_SHORT).show()

                    }

            }

        } else {

            Toast.makeText(this, "Please select image first", Toast.LENGTH_SHORT).show()

        }

    }

    private fun takeImage() {

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try {

            startActivityForResult(intent, requestImageCapture)

        }catch (e: Exception) {


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == requestImageCapture && resultCode == RESULT_OK) {

            val extras: Bundle? = data?.extras

            imageBitmap = extras?.get("data") as Bitmap

            if (imageBitmap != null) {

                binding.imageView.setImageBitmap(imageBitmap)

            }

        }

    }

}