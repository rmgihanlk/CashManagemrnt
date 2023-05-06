package com.example.cashmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ReviewPayment : AppCompatActivity() {

    private lateinit var editTextMerName: EditText
    private lateinit var editTextWalletAdd: EditText
    private lateinit var editTextPayment: EditText
    private lateinit var editTextdesp: EditText
    private lateinit var editTextOrderCode: EditText
    private lateinit var btnApprove: Button
    private lateinit var sqLiteHelper: SQLiteHelper
    private var adapter:PaymentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_payment)

        initView()

        sqLiteHelper = SQLiteHelper(this)

        btnApprove.setOnClickListener{addPayment()}

        adapter?.setOnClickItem {
            Toast.makeText(this, it.payment, Toast.LENGTH_SHORT).show()

        }


        val buttonClick = findViewById<Button>(R.id.btnCancel)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getPayment(){
        val pymList = sqLiteHelper.getAllPayments()
        Log.e("pppp","${pymList.size}")
        adapter?.addItems(pymList)
    }

    private fun addPayment(){
        val payment = editTextMerName.text.toString()
        val amount = editTextWalletAdd.text.toString()
        val date = editTextPayment.text.toString()

        if (payment.isEmpty() || amount.isEmpty() || date.isEmpty()){
            Toast.makeText(this, "Please enter required field", Toast.LENGTH_SHORT).show()
        }else{
            val pym = PaymentModel(payment = payment, amount = amount, date = date)
            val status = sqLiteHelper.insertPayment(pym)

            if(status > -1 ){
                Toast.makeText(this,"Payment Added...", Toast.LENGTH_SHORT).show()
                clearEditText()
                getPayment()

            }else{
                Toast.makeText(this,"Payment not Added...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText() {
        editTextMerName.setText("")
        editTextWalletAdd.setText("")
        editTextPayment.setText("")
        editTextdesp.setText("")
        editTextOrderCode.setText("")
        editTextMerName.requestFocus()

    }


    private fun initView() {
        editTextMerName = findViewById(R.id.editTextMerName)
        editTextWalletAdd = findViewById(R.id.editTextWalletAdd)
        editTextPayment = findViewById(R.id.editTextPayment)
        btnApprove = findViewById(R.id.btnApprove)

    }

}