package com.example.cashmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var btnInsertData: Button
    private lateinit var btnFetchData: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.home)
        setContentView(R.layout.activity_main)

        /*val collection = findViewById<Button>(R.id.b1Coll)
        val outstandClient = findViewById<Button>(R.id.b2Out)
        val overdueInvoices = findViewById<Button>(R.id.b3over)
        val chequeCash = findViewById<Button>(R.id.b4chca)*/

       // val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        btnInsertData = findViewById(R.id.btnInsertData)
        btnFetchData = findViewById(R.id.btnFetchData)

        btnInsertData.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }

        btnFetchData.setOnClickListener {
            val intent = Intent(this, FetchingActivity::class.java)
            startActivity(intent)
        }



      /*  collection.setOnClickListener {
            val intent1= Intent(this,collectionsActivity::class.java)
            startActivity(intent1)
        }

        outstandClient.setOnClickListener {
            val intent2= Intent(this,OutstandClientActivity::class.java)
            startActivity(intent2)
        }

        overdueInvoices.setOnClickListener {
            val intent3= Intent(this,OverdueInvoicesActivity::class.java)
            startActivity(intent3)
        }

        chequeCash.setOnClickListener {
            val intent4= Intent(this,ChequeCashActivity::class.java)
            startActivity(intent4)
        }

    }*/
}
}