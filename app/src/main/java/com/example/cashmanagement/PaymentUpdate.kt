package com.example.cashmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentUpdate : AppCompatActivity() {

    private lateinit var editTextPaymentUpdate: EditText
    private lateinit var editTextAmountUpdate: EditText
    private lateinit var editTextDateUpdate: EditText
    private lateinit var btnUpdatePayment: Button
    private lateinit var btnCancelUpdate: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter:PaymentAdapter? = null
    private var pym: PaymentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_update)

        initView()
        initRecycleView()

        sqLiteHelper = SQLiteHelper(this)
        getPayment()

        btnUpdatePayment.setOnClickListener{updatePayment()}

        adapter?.setOnClickItem {
            Toast.makeText(this, it.payment, Toast.LENGTH_SHORT).show()

            editTextPaymentUpdate.setText(it.payment)
            editTextAmountUpdate.setText(it.amount)
            editTextDateUpdate.setText(it.date)
            pym = it
        }

        val buttonClick01 = findViewById<Button>(R.id.btnCancelUpdate)
        buttonClick01.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updatePayment() {
        val payment = editTextPaymentUpdate.text.toString()
        val amount = editTextAmountUpdate.text.toString()
        val date = editTextDateUpdate.text.toString()

        if (payment == pym?.payment && amount == pym?.amount && date == pym?.date) {
            Toast.makeText(this,"Record not changed...", Toast.LENGTH_SHORT).show()
            return
        }
        if(pym == null) return

        val pym = PaymentModel(id = pym!!.id, payment = payment, amount = amount, date = date)
        val status = sqLiteHelper.updatePayment(pym)

        if (status  > -1){
            clearEditText()
            getPayment()
        }else{
            Toast.makeText(this,"Update Failed...", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getPayment(){
        val pymList = sqLiteHelper.getAllPayments()
        Log.e("pppp","${pymList.size}")
        adapter?.addItems(pymList)
    }

    private fun clearEditText() {
        editTextPaymentUpdate.setText("")
        editTextAmountUpdate.setText("")
        editTextDateUpdate.setText("")
        editTextPaymentUpdate.requestFocus()
    }

    private fun initRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager (this)
        adapter = PaymentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView() {
        editTextPaymentUpdate = findViewById(R.id.editTextPaymentUpdate)
        editTextAmountUpdate = findViewById(R.id.editTextAmountUpdate)
        editTextDateUpdate = findViewById(R.id.editTextDateUpdate)
        btnUpdatePayment = findViewById(R.id.btnUpdatePayment)
        btnCancelUpdate = findViewById(R.id.btnCancelUpdate)
        recyclerView = findViewById(R.id.recycleViewUpdate)
    }
}