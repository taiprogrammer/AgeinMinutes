package com.example.ageinminutes

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.minutes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : AppCompatButton = findViewById(R.id.button_date)

        btn.setOnClickListener { v -> clickDatePicker(v) }
    }

    fun clickDatePicker(v:View) {

        val myCalendar = java.util.Calendar.getInstance()
        val year = myCalendar.get(java.util.Calendar.YEAR)
        val month = myCalendar.get(java.util.Calendar.MONTH)
        val dayOfMonth = myCalendar.get(java.util.Calendar.DAY_OF_MONTH)
        val textDate : AppCompatTextView = findViewById(R.id.date)
        val hintSelectedDate : AppCompatTextView = findViewById(R.id.title_selected_date)
        val hintMinutesDisplayed : AppCompatTextView = findViewById(R.id.hint_minutes)
        val resultMinute : AppCompatTextView = findViewById(R.id.result_minutes)


        DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { v, i, i2, i3 ->

            val selectedDate = "$i3/${i2+1}/$i"

            textDate.text = selectedDate
            hintSelectedDate.visibility = View.VISIBLE

            val simpleDateFormat = SimpleDateFormat("dd/mm/yyyy")
            val theDate = simpleDateFormat.parse(selectedDate)
            val selectedDateInMinutes = theDate!!.time / 60000

            resultMinute.text = selectedDateInMinutes.toString()
            hintMinutesDisplayed.visibility = View.VISIBLE
        }, year, month, dayOfMonth).show()
    }
}