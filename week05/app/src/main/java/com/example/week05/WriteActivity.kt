package com.example.week05

import android.app.DatePickerDialog
import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import java.util.Calendar

class WriteActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()  // 새로운 리스트 생성

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_write)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainLV)

        val adapter_list = ListViewAdapter(dataModelList)

        listView.adapter = adapter_list

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                // 이전에 모델 리스트에 들어있던 값들을 삭제 -> 안그러면 값이 계속 쌓여서 중복 출렫됨
                dataModelList.clear()

                // ??
                for(dataModel in snapshot.children){
                    Log.d("Data:", dataModel.toString())
                    // 데이터모델 리스트에 입력받은 dateModel의 값을 추가
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }
                // 리스트 안에 들어있던 모델들을 앱에 출력
                adapter_list.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // 보통 이곳에서는 오류 로그를 남기는 코드를 작성합니다.
                Log.w("WriteActivity", "데이터 로딩 실패: ", error.toException())
            }
        })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {

            // 커스텀 다이얼로그의 레이아웃을 View 객체로 만듦
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            // 빌더를 통해 AlertDialog를 생성하고 화면에 표시
            val mAlertDialog = mBuilder.show()

            val DateSelectBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)

            var dateText = ""

            DateSelectBtn?.setOnClickListener {
                // 여기 물음표 붙이는 이유가 뭔데?

                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)  // month는 0부터 시작 (0=1월, 1=2월, ...)
                val date: Int = today.get(Calendar.DATE)

                // 날짜 선택 달력 생성
                val dlg = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        DateSelectBtn.setText("${year}, ${month+1}, ${dayOfMonth}")

                        dateText = "${year}, ${month+1}, ${dayOfMonth}"
                    }
                }, year, month, date)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {

                val healMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val database = Firebase.database
                // myMemo라는 최상위 경로 참조
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)

                val model = DataModel(dateText, healMemo)

                myRef
                    .push()
                    .setValue(model)

                mAlertDialog.dismiss()
            }

        }
    }
}