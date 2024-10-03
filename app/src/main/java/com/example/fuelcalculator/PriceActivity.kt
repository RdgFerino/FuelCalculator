package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "priceActivity.KEY_INPUT_PRICE"
class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrice = findViewById<TextInputEditText>(R.id.edt_Price)
        val btnProxi1 = findViewById<Button>(R.id.btn_proxi1)

        btnProxi1.setOnClickListener {
            val priceStr: String = edtPrice.text.toString()
            if (priceStr == "") {
                Snackbar.make(
                    edtPrice, "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val price = edtPrice.text.toString().toFloat()
                val intent = Intent(this, ConsumptionActivity::class.java)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }

        }
    }
}