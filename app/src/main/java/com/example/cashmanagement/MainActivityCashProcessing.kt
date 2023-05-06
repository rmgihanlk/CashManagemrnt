package com.example.cashmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityCashProcessing : AppCompatActivity() {

    //private lateinit var editTextPayment01: EditText
    //private lateinit var editTextAmount01: EditText
    //private lateinit var editTextDate01: EditText
    private lateinit var btnmenuAdd: Button
    private lateinit var btnList: Button
    private lateinit var btnUpdate: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter:PaymentAdapter? = null
    private var pym: PaymentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cash_processing)

        initView()
        initRecycleView()

        sqLiteHelper = SQLiteHelper(this)

        //btnAdd.setOnClickListener{addPayment()}
        //btnHome.setOnClickListener{getPayment()}
        //btnUpdate.setOnClickListener{updatePayment()}

/*        adapter?.setOnClickItem {
            Toast.makeText(this, it.payment, Toast.LENGTH_SHORT).show()

            editTextPayment01.setText(it.payment)
            editTextAmount01.setText(it.amount)
            editTextDate01.setText(it.date)
            pym = it
        }*/

/*
        adapter?.setOnClickDelete {
            deletePayment(it.id)
        }
*/

        val buttonClick = findViewById<Button>(R.id.btnList)
        buttonClick.setOnClickListener {
            val intent = Intent(this, PaymentProcess::class.java)
            startActivity(intent)
        }

        val buttonClick01 = findViewById<Button>(R.id.btnmenuAdd)
        buttonClick01.setOnClickListener {
            val intent = Intent(this, ReviewPayment::class.java)
            startActivity(intent)
        }

        val buttonClick02 = findViewById<Button>(R.id.btnUpdate)
        buttonClick02.setOnClickListener {
            val intent = Intent(this, PaymentUpdate::class.java)
            startActivity(intent)
        }

    }

    /*private fun updatePayment() {
        val payment = editTextPayment01.text.toString()
        val amount = editTextAmount01.text.toString()
        val date = editTextDate01.text.toString()

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
            Toast.makeText(this,"Update Failed...",Toast.LENGTH_SHORT).show()
        }
    }*/

    /*private fun deletePayment(id: Int){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to cancel this payment?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes") { dialog, _ ->
            sqLiteHelper.deletePayment(id)
            getPayment()
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }*/

    /*private fun getPayment(){
        val pymList = sqLiteHelper.getAllPayments()
        Log.e("pppp","${pymList.size}")
        adapter?.addItems(pymList)
    }*/

    /*private fun addPayment(){
        val payment = editTextPayment01.text.toString()
        val amount = editTextAmount01.text.toString()
        val date = editTextDate01.text.toString()

        if (payment.isEmpty() || amount.isEmpty() || date.isEmpty()){
            Toast.makeText(this, "Please enter required field", Toast.LENGTH_SHORT).show()
        }else{
            val pym = PaymentModel(payment = payment, amount = amount, date = date)
            val status = sqLiteHelper.insertPayment(pym)

            if(status > -1 ){
                Toast.makeText(this,"Payment Added...",Toast.LENGTH_SHORT).show()
                clearEditText()
                getPayment()

            }else{
                Toast.makeText(this,"Payment not Added...",Toast.LENGTH_SHORT).show()
            }
        }
    }*/

/*    private fun clearEditText() {
        editTextPayment01.setText("")
        editTextAmount01.setText("")
        editTextDate01.setText("")
        editTextPayment01.requestFocus()
    }*/

    private fun initRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager (this)
        adapter = PaymentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView() {
/*        editTextPayment01 = findViewById(R.id.editTextPayment01)
        editTextAmount01 = findViewById(R.id.editTextAmount01)
        editTextDate01 = findViewById(R.id.editTextDate01)*/
        btnmenuAdd = findViewById(R.id.btnmenuAdd)
        btnList = findViewById(R.id.btnList)
        btnUpdate = findViewById(R.id.btnUpdate)
        //recyclerView = findViewById(R.id.recycleViewList)
    }

}