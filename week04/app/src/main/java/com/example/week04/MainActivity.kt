package com.example.week04

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.util.Log.e
import android.widget.ListView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {

    private  var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addOnBackPressedCallback()

    }
    private fun addOnBackPressedCallback() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // 뒤로 가기 버튼이 2번 눌렸을 때 처리 동작
                if(isDouble == true){
                    finish()
                    return
                }

                // 한 번 클릭하면 변수 true
                isDouble = true
                Toast.makeText(this@MainActivity, "종료할거면 더블클릭", Toast.LENGTH_LONG).show()

                android.os.Handler(Looper.getMainLooper()).postDelayed({
                    isDouble = false
                }, 2000)
            }
        }

        this.onBackPressedDispatcher.addCallback(this, callback)
    }
}