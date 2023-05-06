package com.example.cashmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentProcessingSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_processing_summary)

        val buttonClick = findViewById<Button>(R.id.btnCancelSummary)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivityCashProcessing::class.java)
            startActivity(intent)
        }

    }
}