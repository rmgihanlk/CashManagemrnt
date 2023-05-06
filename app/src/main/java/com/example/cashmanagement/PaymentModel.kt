package com.example.cashmanagement

import java.time.temporal.TemporalAmount
import java.util.*

class PaymentModel(
    var id: Int = getAutoId(),
    var payment: String = "",
    var amount: String = "",
    var date: String = ""
){
    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}