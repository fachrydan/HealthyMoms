package com.skripsi.healthymoms

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class PrediksiTglLahir : AppCompatActivity() {

    private lateinit var tvDate: TextView
    private lateinit var tvHpl: TextView
    private lateinit var cal : Calendar
    private lateinit var spSiklus : Spinner
    private lateinit var btnHitung : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setContentView(R.layout.activity_prediksi_tgl_lahir)

        tvDate = findViewById(R.id.tvDate)
        spSiklus = findViewById(R.id.spSiklus)
        btnHitung = findViewById(R.id.btnHitung)
        tvHpl = findViewById(R.id.tvHpl)
        cal = Calendar.getInstance()

        ArrayAdapter.createFromResource(
            this,
            R.array.periode_siklus,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spSiklus.adapter = adapter
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        tvDate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@PrediksiTglLahir,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnHitung.setOnClickListener{
            val cal : Calendar = Calendar.getInstance()
            val siklus = Integer.parseInt(spSiklus.selectedItem.toString().filter { it.isDigit() })
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            val diff = siklus - 28
            Log.i("MASE", "Siklus: $siklus : $diff")

            val sdf = SimpleDateFormat("dd/MM/yyyy")
            cal.time = sdf.parse(tvDate.text as String)
            cal.add(Calendar.DAY_OF_MONTH, 7)
            cal.add(Calendar.DAY_OF_MONTH, diff)
            cal.add(Calendar.MONTH, 9)
            val d : Date = cal.time
            Log.i("MASE 2", d.toString())
            val ld : LocalDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

            tvHpl.text = "Hari Perkiraan Lahir: ${ld.format(formatter)}"

        }
    }

    private fun updateDateInView(){
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        tvDate.setText(sdf.format(cal.time))
    }

}