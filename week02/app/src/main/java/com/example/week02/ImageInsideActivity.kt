package com.example.week02

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_inside)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getData = intent.getStringExtra("data")

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        if(getData == "1"){
            memberImage.setImageResource(R.drawable.kko1)
        }
        if(getData == "2"){
            memberImage.setImageResource(R.drawable.kko2)
        }
        if(getData == "3"){
            memberImage.setImageResource(R.drawable.kko3)
        }
        if(getData == "4"){
            memberImage.setImageResource(R.drawable.kko4)
        }
        if(getData == "5"){
            memberImage.setImageResource(R.drawable.kko5)
        }
        if(getData == "6"){
            memberImage.setImageResource(R.drawable.kko6)
        }
        if(getData == "7"){
            memberImage.setImageResource(R.drawable.kko7)
        }
        if(getData == "8"){
            memberImage.setImageResource(R.drawable.kko8)
        }
        if(getData == "9"){
            memberImage.setImageResource(R.drawable.kko9)
        }
    }
}