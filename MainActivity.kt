package com.example.notesapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {


    var rg: RadioGroup?=null
    lateinit var rb: RadioButton
    lateinit var bt: Button
    lateinit var etFullName: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etDateOfBirth: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rg = findViewById(R.id.radioGroupGender)
        bt=findViewById(R.id.create)
        etFullName=findViewById(R.id.etName)
        etEmail=findViewById(R.id.etEmailAddress)
        etPassword=findViewById(R.id.etPassword)
    }


    fun clickOnDateOfBirth(view: View) {
        val calendar= Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener
        { view, year, monthOfYear, dayOfMonth ->

            etDateOfBirth.setText("" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year)

        }, year, month, day)

        datePickerDialog.show()
    }
    private fun checkName(){
        val name=etFullName.text.toString()
        if (name.isEmpty()|| name.length<3)
        {
            etFullName.error="Enter your name"
        }
    }
    private fun checkEmail(){
        val mail=etEmail.text.toString()
        if (!mail.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(mail).matches()){

        }
        else {
            etEmail.error="Enter correct email"
        }
    }
    private fun checkPassword(){
        val cpassword=etPassword.text.toString()
        if (cpassword.isEmpty()){
            etPassword.error="Password Required"
        }
    }



    fun buttonClick(view: View) {
        // checking mail , password and name
        checkName()
        checkEmail()
        checkPassword()

        //   val name=etFullName.text.toString()
        //   val mail=etEmail.text.toString()
        //   val cpassword=etPassword.text.toString()
        //    if (name.isEmpty()|| name.length<3)
        //  {
        //     etFullName.error="Enter your name"
        //  }
        //    if (mail.isEmpty()){
        //        etEmail.error="Enter your mail"
        //    }
        //   if (cpassword.isEmpty()){
        //       etPassword.error="Password Required"
        //}

        //    radio button
        val intSelectButton: Int = rg!!.checkedRadioButtonId
        rb = findViewById(intSelectButton)

        //    Button after creating
        Toast.makeText(baseContext, bt.text, Toast.LENGTH_SHORT).show()

       // Toast.makeText(applicationContext, "Created", Toast.LENGTH_SHORT).show()
    }


}