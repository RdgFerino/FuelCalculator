package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            
        }

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvPrice = findViewById<TextView>(R.id.tv_Plabel)
        val tvConsum = findViewById<TextView>(R.id.tv_Clabel)
        val tvDist = findViewById<TextView>(R.id.tv_Kmlabel)


        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consum = intent.getFloatExtra(KEY_CONSUM, 0f)
        val dist = intent.getFloatExtra(KEY_DISTAN, 0f)

        val btnBack = findViewById<Button>(R.id.btn_back)

        tvPrice.text = price.toString()
        tvConsum.text = consum.toString()
        tvDist.text = dist.toString()

        val result = (dist / consum) * price

        tvResult.text = "R$ %.2f".format(result)

        btnBack.setOnClickListener {
            val intent = Intent(this, PriceActivity::class.java)
            startActivity(intent)
        }
    }
}