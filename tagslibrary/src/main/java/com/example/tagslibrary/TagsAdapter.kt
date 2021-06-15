package com.example.tagslibrary

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TagsAdapter :
    RecyclerView.Adapter<TagsAdapter.MyViewHolder>() {

    var tagAdded: MutableList<String> = mutableListOf()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val TAG = MyViewHolder::class.simpleName
        val tagValue = itemView.findViewById<TextView>(R.id.getTagName)
        val cross = itemView.findViewById<ImageView>(R.id.getTagCross)
        val card = itemView.findViewById<CardView>(R.id.container_card)

        fun bindPost(_tag: String) {


            Log.e(TAG, "Adding tag $_tag")
            with(_tag) {
                tagValue.text = _tag
                //OnClickListener for the tag cross

            }
        }


    }

    fun updateList(_tag: String, position: Int) {
        tagAdded.add(_tag)
        notifyItemInserted(position)        //Not needed
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        tagAdded.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, tagAdded.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        return TagsAdapter.MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return tagAdded.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cross.setOnClickListener {
            removeAt(position)
        }



        holder.bindPost(tagAdded[position])

    }

}

interface OnClickingTagListener{

}

