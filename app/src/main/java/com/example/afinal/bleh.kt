package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_bleh.*

class bleh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bleh)
//        val etShowNumber = findViewById<EditText>(R.id.etShowNumber)
//        val bu0 = findViewById<Button>(R.id.bu0)
//        val bu1 = findViewById<Button>(R.id.bu1)
//        val bu2 = findViewById<Button>(R.id.bu2)
//        val bu3 = findViewById<Button>(R.id.bu3)
//        val bu4 = findViewById<Button>(R.id.bu4)
//        val bu5 = findViewById<Button>(R.id.bu5)
//        val bu6 = findViewById<Button>(R.id.bu6)
//        val bu7 = findViewById<Button>(R.id.bu7)
//        val bu8 = findViewById<Button>(R.id.bu8)
//        val bu9 = findViewById<Button>(R.id.bu9)
//        val buPlusMinus = findViewById<Button>(R.id.buPlusMinus)
//        val buSum = findViewById<Button>(R.id.buSum)
//        val buMul = findViewById<Button>(R.id.buMul)
//        val buDiv = findViewById<Button>(R.id.buDiv)
//        val buSub = findViewById<Button>(R.id.buSub)
//        val buDot = findViewById<Button>(R.id.buDot)

    }
    var isNewOp=true
    var dot=false
    fun buNumberEvent(view: View)
    {
        if(isNewOp)
        {
            etShowNumber.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id)
        {
            bu0.id->
            {
                buClickValue+="0"
            }
            bu1.id->
            {
                buClickValue+="1"
            }
            bu2.id->
            {
                buClickValue+="2"
            }
            bu3.id->
            {
                buClickValue+="3"
            }
            bu4.id->
            {
                buClickValue+="4"
            }
            bu5.id->
            {
                buClickValue+="5"
            }
            bu6.id->
            {
                buClickValue+="6"
            }
            bu7.id->
            {
                buClickValue+="7"
            }
            bu8.id->
            {
                buClickValue+="8"
            }
            bu9.id->
            {
                buClickValue+="9"
            }
            buDot.id->
            {
                if(dot==false)
                {
                    buClickValue += "."
                }
                dot=true
            }
            buPlusMinus.id->
            {
                buClickValue="-" + buClickValue
            }
        }
        etShowNumber.setText(buClickValue)
    }
    var op="X"
    var oldNumber=""

    fun buOpEvent(view: View)
    {
        val buSelect= view as Button
        when(buSelect.id)
        {
            buMul.id->
            {
                op="X"
            }
            buDiv.id->
            {
                op="÷"
            }
            buSub.id->
            {
                op="-"
            }
            buSum.id->
            {
                op="+"
            }
        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
        dot=false
    }

    fun buEqualEvent(view: View)
    {
        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "X"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View)
    {
        val number=(etShowNumber.text.toString().toDouble())/100
        etShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View)
    {
        etShowNumber.setText("")
        isNewOp=true
        dot=false
    }
}