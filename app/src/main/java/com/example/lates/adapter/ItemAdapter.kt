package com.example.lates.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lates.networking.Article
import com.example.lates.R
import com.example.lates.SecondActivity


class ItemAdapter(
    private val context: Context,
    private val dataset: List<Article>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, SecondActivity::class.java)
            intent.putExtra("name", item.title);
            intent.putExtra("image", item.urlToImage)
            intent.putExtra("description", item.description)
            intent.putExtra("source", item.url)
            it.context.startActivity(intent)
        }

        holder.textView.text = item.title
        Glide.with(context)
            .load(item.urlToImage)
            .into(holder.imageView)
    }
}