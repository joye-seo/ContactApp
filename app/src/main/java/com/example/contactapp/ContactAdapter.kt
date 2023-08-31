package com.example.contactapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        TYPE_CONTACT -> {
            ContactHolder.create(parent)
        }

        TYPE_AD -> {
            AdHolder.create(parent)
        }

        else -> {
            throw IllegalStateException("Not Found ViewHolder Type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContactHolder -> {
                holder.bind(items[position] as Data)
            }

            is AdHolder -> {
                holder.bind(items[position] as AdData)
            }
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Data -> {
            TYPE_CONTACT
        }

        is AdData -> {
            TYPE_AD
        }

        else -> {
            throw IllegalStateException("Not Found ViewHolder Type")
        }
    }

    class ContactHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val number = itemView.findViewById<TextView>(R.id.tv_number)
        val call = itemView.findViewById<ImageView>(R.id.btn_call)
        val profile = itemView.findViewById<ImageView>(R.id.iv_profile)


        fun bind(item: Data) {
            name.text = item.name
            number.text = item.number
            profile.setImageResource(item.picture)

            call.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${item.number}")
                }
                itemView.context.startActivity(intent)
            }
        }

        companion object Factory {
            fun create(parent: ViewGroup): ContactHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_contact_list, parent, false)

                return ContactHolder(view)
            }
        }

    }

    class AdHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val adImage = itemView.findViewById<ImageView>(R.id.iv_ad)


        fun bind(item: AdData) {
            adImage.setImageResource(item.ad)
        }

        companion object Factory {
            fun create(parent: ViewGroup): AdHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_ad, parent, false)

                return AdHolder(view)
            }
        }
    }

    fun addItems(item: Item) {
        this.items.add(item)
        this.notifyDataSetChanged()
    }

    companion object {
        private const val TYPE_CONTACT = 0
        private const val TYPE_AD = 1

    }

}
