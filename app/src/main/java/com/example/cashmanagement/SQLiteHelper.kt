package com.example.cashmanagement

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "payments.db"
        private const val TBL_PAYMENT = "tbl_payment"
        private const val ID = "id"
        private const val PAYMENT = "payment"
        private const val AMOUNT = "amount"
        private const val DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblPayment = ("CREATE TABLE " + TBL_PAYMENT + "("
                + ID + " INTEGER PRIMARY KEY,"
                + PAYMENT + " TEXT,"
                + AMOUNT + " TEXT,"
                + DATE + " TEXT" + ")")
        db?.execSQL(createTblPayment)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_PAYMENT")
        onCreate(db)
    }

    fun insertPayment(pym:PaymentModel): Long{

        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, pym.id)
        contentValues.put(PAYMENT, pym.payment)
        contentValues.put(AMOUNT, pym.amount)
        contentValues.put(DATE, pym.date)

        val success = db.insert(TBL_PAYMENT, null, contentValues)
        db.close()
        return success
    }

    fun updatePayment(pym:PaymentModel): Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, pym.id)
        contentValues.put(PAYMENT,pym.payment)
        contentValues.put(AMOUNT,pym.amount)
        contentValues.put(DATE,pym.date)

        val success = db.update(TBL_PAYMENT,contentValues, "id", null)
        db.close()
        return success
    }

    fun deletePayment(id: Int): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, id)
        val success = db.delete(TBL_PAYMENT, "id=$id", null)
        db.close()
        return success
    }


    @SuppressLint("Range")
    fun getAllPayments(): ArrayList<PaymentModel>{
        var pymList: ArrayList<PaymentModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_PAYMENT"
        val db = this.readableDatabase

        val cursor: Cursor

        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id:Int
        var payment:String
        var amount:String
        var date:String

        val columnIndex = cursor.getColumnIndex("id")
        if (columnIndex != -1) {

            if(cursor.moveToFirst()){
                do{
                    id = cursor.getInt(cursor.getColumnIndex("id"))
                    payment = cursor.getString(cursor.getColumnIndex("payment"))
                    amount = cursor.getString(cursor.getColumnIndex("amount"))
                    date = cursor.getString(cursor.getColumnIndex("date"))

                    val pym = PaymentModel(id = id, payment = payment, amount = amount, date = date)
                    pymList.add(pym)
                }while (cursor.moveToNext())
            }

            return pymList
        }

        return pymList
    }
}