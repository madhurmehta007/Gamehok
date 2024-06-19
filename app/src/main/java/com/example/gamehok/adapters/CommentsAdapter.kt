package com.example.gamehok.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamehok.databinding.ItemCommentBinding
import com.example.gamehok.models.Comments

class CommentsAdapter (
    val context: Context,
    val commentsList:MutableList<Comments>
):
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>(){

    class CommentsViewHolder(val binding: ItemCommentBinding, context: Context):
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCommentBinding.inflate(layoutInflater, parent, false)

        return CommentsViewHolder(binding, parent.context)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comments = commentsList[position]

        holder.binding.tvCommentAuthor.text = comments.author
        holder.binding.tvCommentContent.text = comments.content
        holder.binding.tvCommentDate.text = comments.date

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

}