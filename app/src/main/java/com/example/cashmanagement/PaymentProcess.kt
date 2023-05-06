package com.example.cashmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentProcess : AppCompatActivity() {

    //private lateinit var editTextPayment01: EditText
    //private lateinit var editTextAmount01: EditText
    //private lateinit var editTextDate01: EditText
    //private lateinit var btnAdd: Button
    private lateinit var btnApproveAll: Button
    //private lateinit var btnUpdate: Button

    private lateinit var sqLiteHelper: SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter:PaymentAdapter? = null
    //private var pym: PaymentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_process)


        initView()
        initRecycleView()

        //btnApproveAll.setOnClickListener{getPayment()}

        adapter?.setOnClickItem {
            Toast.makeText(this, it.payment, Toast.LENGTH_SHORT).show()

            //editTextPayment01.setText(it.payment)
            //editTextAmount01.setText(it.amount)
            //editTextDate01.setText(it.date)
            //pym = it
        }

        sqLiteHelper = SQLiteHelper(this)
        getPayment()

        adapter?.setOnClickItem {
            Toast.makeText(this, it.payment, Toast.LENGTH_SHORT).show()

            //editTextPayment01.setText(it.payment)
            //editTextAmount01.setText(it.amount)
            //editTextDate01.setText(it.date)
            //pym = it
        }

        adapter?.setOnClickDelete {
            deletePayment(it.id)
        }

    }


    private fun deletePayment(id: Int){
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
    }

    private fun getPayment(){
        val pymList = sqLiteHelper.getAllPayments()
        Log.e("pppp","${pymList.size}")
        adapter?.addItems(pymList)
    }

    private fun initRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager (this)
        adapter = PaymentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView() {
        //editTextPayment01 = findViewById(R.id.editTextPayment01)
        //editTextAmount01 = findViewById(R.id.editTextAmount01)
        //editTextDate01 = findViewById(R.id.editTextDate01)
        //btnAdd = findViewById(R.id.btnAdd)
        btnApproveAll = findViewById(R.id.btnApproveAll)
        //btnUpdate = findViewById(R.id.btnUpdate)
        recyclerView = findViewById(R.id.recycleView)
    }

}