package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var dateView:TextView?=null
    private var minutes:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker=findViewById<Button>(R.id.btnDatePicker)
        dateView=findViewById(R.id.SelectedDate)
        minutes=findViewById((R.id.Minutes))
        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }
    }
   private val clickDatePicker= {
       val myCalendar=Calendar.getInstance()
       val year=myCalendar[Calendar.YEAR]
       val month=myCalendar[Calendar.MONTH]
       val day=myCalendar[Calendar.DAY_OF_MONTH]
      val dpk= DatePickerDialog(this,{_,selectedYear,selectedMonth,selectedDay ->

           val date="$selectedDay/ ${selectedMonth+1}/ $selectedYear"
           dateView?.text=date
          val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
          val dob= (sdf.parse(date)?.time)?.div(60000)
          val currentDate=(sdf.parse(sdf.format(System.currentTimeMillis()))?.time)?.div(60000)
          val minutesText: Long = currentDate!! - dob!!
          minutes?.text=minutesText.toString()



       },year,month,day)
       dpk.datePicker.maxDate=System.currentTimeMillis()-(86400000)
       dpk.show()
       }

}