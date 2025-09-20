package com.example.section02

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. 화면이 클릭됨
        val image1 = findViewById<ImageView>(R.id.img1)
        image1.setOnClickListener {
            // 2.화면이 클릭되면, 다음 화면으로 넘어감
            val intent = Intent(this, Photo1Activity::class.java)
            startActivity(intent)
        }

        val image2 = findViewById<ImageView>(R.id.img2)
        val image3 = findViewById<ImageView>(R.id.img3)
        val image4 = findViewById<ImageView>(R.id.img4)
        val image5 = findViewById<ImageView>(R.id.img5)
        val image6 = findViewById<ImageView>(R.id.img6)
        val image7 = findViewById<ImageView>(R.id.img7)

        image2.setOnClickListener {
            val intent = Intent(this, Photo2Activity::class.java)
            startActivity(intent)
        }

        image3.setOnClickListener {
            val intent = Intent(this, Photo3Activity::class.java)
            startActivity(intent)
        }

        image4.setOnClickListener {
            val intent = Intent(this, Photo4Activity::class.java)
            startActivity(intent)
        }

        image5.setOnClickListener {
            val intent = Intent(this, Photo5Activity::class.java)
            startActivity(intent)
        }

        image6.setOnClickListener {
            val intent = Intent(this, Photo6Activity::class.java)
            startActivity(intent)
        }

        image7.setOnClickListener {
            val intent = Intent(this, Photo7Activity::class.java)
            startActivity(intent)
        }
        
    }
}