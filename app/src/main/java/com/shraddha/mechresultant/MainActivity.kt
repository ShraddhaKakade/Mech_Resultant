package com.shraddha.mechresultant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    lateinit var edtxtF1 : EditText
    lateinit var edtxtF2 : EditText
    lateinit var edtxtAngle : EditText
    lateinit var txtResultant : TextView
    lateinit var txtDirection : TextView
    lateinit var btnResultant : Button
    lateinit var btnDirection : Button
    lateinit var btnClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtxtF1 = findViewById(R.id.edtxtF1)
        edtxtF2 = findViewById(R.id.edtxtF2)
        edtxtAngle = findViewById(R.id.edtxtAngle)
        txtDirection = findViewById(R.id.txtDirection)
        txtResultant = findViewById(R.id.txtResultant)
        btnDirection = findViewById(R.id.btnDirection)
        btnResultant = findViewById(R.id.btnResultant)
        btnClear = findViewById(R.id.btnClear)

        var rad = PI/180;
        var deg = 1/rad;

        btnResultant.setOnClickListener(View.OnClickListener {
            try {
                var force1 = (edtxtF1.text.toString()).toDouble()
                var force2 = (edtxtF2.text.toString()).toDouble()
                var angle = (edtxtAngle.text.toString()).toDouble()
                var f1 = force1 * force1
                var f2 = force2 * force2
                var f = 2 * force1 * force2 * (cos(angle * rad))
                var total = f1 + f2 + f
                var Resultant = sqrt(total)
                txtResultant.text = "Resultant is : " + Resultant.toString() + " N"
            }
            catch(e : Exception) {
                Toast.makeText(applicationContext, "Data entered is invalid !", Toast.LENGTH_LONG).show()
            }
        })

        btnDirection.setOnClickListener(View.OnClickListener {
            try {
                var force1 = (edtxtF1.text.toString()).toDouble()
                var force2 = (edtxtF2.text.toString()).toDouble()
                var angle = (edtxtAngle.text.toString()).toDouble()
                var n = force2 * (sin(angle * rad))
                var d = force1 + (force2 * (cos(angle * rad)))
                var Direction = (atan(n / d)) * deg
                txtDirection.text = "Direction is : " + Direction.toString() + " Deg"
            }
            catch(e : Exception) {
                Toast.makeText(applicationContext, "Data entered is invalid !", Toast.LENGTH_LONG).show()
            }

        })

        btnClear.setOnClickListener(View.OnClickListener {

            edtxtF1.setText("")
            edtxtF2.setText("")
            edtxtAngle.setText("")
            txtDirection.setText("")
            txtResultant.setText("")

        })
    }
}
