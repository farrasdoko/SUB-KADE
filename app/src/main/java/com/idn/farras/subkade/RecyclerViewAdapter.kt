package com.idn.farras.subkade

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ScrollingTabContainerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*
import com.idn.farras.subkade.R.layout.item_list
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context,
                          private val items: List<Items>,
                          private val listener: (Items) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            viewHolder(LayoutInflater.from(context).inflate(item_list, p0, false))

    override fun onBindViewHolder(p0: viewHolder, p1: Int) {
        p0.bindItem(items[p1], listener)
    }

    override fun getItemCount(): Int = items.size

    class viewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(items: Items, listener: (Items) -> Unit) {
            name.text = items.name
            items.image?.let { Picasso.get().load(it).into(image) }
            containerView.setOnClickListener { listener(items) }
        }
    }

}