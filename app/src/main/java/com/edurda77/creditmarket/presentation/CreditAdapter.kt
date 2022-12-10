package com.edurda77.creditmarket.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.creditmarket.databinding.ItemCreditBinding
import com.edurda77.creditmarket.domain.entity.CreditMarketData

class CreditAdapter (
    private val list: List<CreditMarketData>,
    private val onStateClickListener: OnStateClickListener
) :
RecyclerView.Adapter<CreditHolder>(){

    interface OnStateClickListener {
        fun onStateClick(itemCreditMarketData: CreditMarketData)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CreditHolder(ItemCreditBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: CreditHolder, position: Int) {
        val creditMarketData = list[position]
        holder.bind(creditMarketData)

        holder.onGoingToWeb.setOnClickListener{
            onStateClickListener.onStateClick(creditMarketData)
        }
    }

    override fun getItemCount(): Int = list.size
}