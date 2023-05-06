package com.example.cashmanagement

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentAdapter : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>(){

    private var pymList:ArrayList<PaymentModel> = ArrayList()
    private var onClickListener:((PaymentModel)->Unit)? = null
    private var onClickDeleteItem: ((PaymentModel)->Unit)? = null

    fun addItems(items: ArrayList<PaymentModel>){
        this.pymList = items
        notifyDataSetChanged()
    }

    fun setOnClickDelete(callback: (PaymentModel) -> Unit){
        this.onClickDeleteItem = callback
    }

    fun setOnClickItem(callback: (PaymentModel)->Unit){
        this.onClickListener = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PaymentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_items_payments,parent,false))

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val pym = pymList[position]
        holder.bindView(pym)
        holder.itemView.setOnClickListener {onClickListener?.invoke(pym)}
        holder.btnDelete.setOnClickListener{onClickDeleteItem?.invoke(pym)}
    }

    override fun getItemCount(): Int {
        return pymList.size
    }

    class PaymentViewHolder(var view: View):RecyclerView.ViewHolder(view) {
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var payment = view.findViewById<TextView>(R.id.tvPayment)
        private var amount = view.findViewById<TextView>(R.id.tvAmount)
        private var date = view.findViewById<TextView>(R.id.tvDate)
        var btnDelete = view.findViewById<Button>(R.id.btnDelete)

        fun bindView(pym: PaymentModel) {
            id.text = pym.id.toString()
            payment.text = pym.payment
            amount.text = pym.amount
            date.text = pym.date
        }

    }
}