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

const val KEY_DISTAN= "DistanceActivity.KEY_INPUT_DISTANCE"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consum = intent.getFloatExtra(KEY_CONSUM, 0f)

        val edtDist = findViewById<TextInputEditText>(R.id.edt_Dist)
        val btnresul = findViewById<Button>(R.id.btn_resul)

        btnresul.setOnClickListener {
            val distStr: String = edtDist.text.toString()
            if (distStr == ""){
                Snackbar.make(edtDist, "Preencha todos os campos",
                    Snackbar.LENGTH_LONG).show()
            } else {
                val dist = edtDist.text.toString().toFloat()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_DISTAN, dist)
                intent.putExtra(KEY_CONSUM, consum)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)

            }

        }
    }
}