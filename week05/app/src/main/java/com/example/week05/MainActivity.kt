package com.example.week05

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        val anonymousLoginButton: Button = findViewById(R.id.noEmailLogin)
        anonymousLoginButton.setOnClickListener {
            signInAnonymously()
        }
    }

    private fun signInAnonymously() {
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 로그인 성공
                    Log.d("MainActivity", "UID: ${auth.currentUser?.uid}")
                    Toast.makeText(baseContext, "익명 로그인 성공", Toast.LENGTH_SHORT).show()

                    // 로그인 성공 후 "WriteActivity"로 화면 전환
                    val intent = Intent(this, WriteActivity::class.java)
                    startActivity(intent)

                    // 현재 MainActivity를 완전 종료 -> 뒤로가기 버튼을 눌렀을 때 돌아오지 않도록
                    finish()

                } else {
                    // 로그인 실패
                    Log.w("MainActivity", "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "인증에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
            }
    }

}