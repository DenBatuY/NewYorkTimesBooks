package com.example.newyorktimesbooks.presentation.adapters.buy_links_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesbooks.databinding.BuyLinkItemBinding
import com.example.newyorktimesbooks.domain.entitys.BuyLinkEntity

class BuyLinksAdapter :
    RecyclerView.Adapter<BuyLinksAdapter.BuyLinksViewHolder>() {

    private var links: List<BuyLinkEntity> = emptyList()
    fun setLinks(links: List<BuyLinkEntity>) {
        this.links = links
        notifyDataSetChanged()
    }

    var onClickLink: ((link: String) -> Unit)? = null

    inner class BuyLinksViewHolder(val binding: BuyLinkItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuyLinksAdapter.BuyLinksViewHolder {
        val binding = BuyLinkItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyLinksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyLinksAdapter.BuyLinksViewHolder, position: Int) {
        val link = links[position]
        holder.binding.btLink.text = link.name
        holder.binding.btLink.setOnClickListener {
            onClickLink?.invoke(link.url)
        }
    }

    override fun getItemCount(): Int = links.size
}