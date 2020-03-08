package com.example.travel_expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (v.id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {


        if (validation()) {

            try {
                val distance: Int = editDistance.text.toString().toInt()
                val price: Double = editPrice.text.toString().toDouble()
                val autonomy: Double = editAutonomy.text.toString().toDouble()

                val total = (distance * price) / autonomy
                textTotal.text = "${textTotal.text}: ${"%.2f".format(total)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.invalid_values), Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.fill_in_all_fields), Toast.LENGTH_LONG).show()

        }


    }

    private fun validation(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0")
    }

}
