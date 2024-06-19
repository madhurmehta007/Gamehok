package com.example.gamehok.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamehok.databinding.ItemRelatedGameBinding
import com.example.gamehok.models.Games

class RelatedGamesAdapter(
    val context: Context,
    val relatedGamesList:MutableList<Games>
):
    RecyclerView.Adapter<RelatedGamesAdapter.RelatedGamesViewHolder>(){

    class RelatedGamesViewHolder(val binding: ItemRelatedGameBinding, context: Context):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedGamesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRelatedGameBinding.inflate(layoutInflater, parent, false)

        return RelatedGamesViewHolder(binding, parent.context)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RelatedGamesViewHolder, position: Int) {
        val games = relatedGamesList[position]

        holder.binding.tvRelatedGameTitle.text = games.title

    }

    override fun getItemCount(): Int {
        return relatedGamesList.size
    }


}