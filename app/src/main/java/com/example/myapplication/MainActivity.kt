package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

private val FILENAME = "".toByteArray()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_main)

//        findViewById<PDFView>(R.id.activity_main_pdf_view).fromBase64(
//            FILENAME
//        ).show()
    }
}