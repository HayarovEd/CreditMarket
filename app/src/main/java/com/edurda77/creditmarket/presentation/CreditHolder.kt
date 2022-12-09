package com.edurda77.creditmarket.presentation

import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edurda77.creditmarket.databinding.ItemCreditBinding
import com.edurda77.creditmarket.domain.entity.CreditMarketData

class CreditHolder (private val binding: ItemCreditBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val onGoingToWeb: Button = binding.takeManyBt

    fun bind(item: CreditMarketData) {
        binding.upSumTv.text = item.sumOne
        binding.rateTv.text = "сСтавка от ${item.percent}"
        Glide.with(this.itemView.context)
            .load(item.imageUrl)
            .into(binding.posterIv)
    }

}