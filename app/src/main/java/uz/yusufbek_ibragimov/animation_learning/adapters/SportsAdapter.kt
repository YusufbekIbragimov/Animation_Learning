package uz.yusufbek_ibragimov.animation_learning.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.yusufbek_ibragimov.animation_learning.R
import uz.yusufbek_ibragimov.animation_learning.Sports
import uz.yusufbek_ibragimov.animation_learning.databinding.ItemSportsBinding
import uz.yusufbek_ibragimov.animation_learning.fragments.Fragment_D

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 09.06.2021
 * ibragimovy390@gmail.com
 * */

class SportsAdapter(
    private val sportsList: ArrayList<Sports>,
    private val onClickListener: OnImgClickListener
) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>() {

    class SportsViewHolder(var binding: ItemSportsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            sports: Sports,
            onClickListener: OnImgClickListener
        ) {
            binding.banner.setImageResource(sports.banner)
            binding.banner.transitionName = sports.banner.toString()
            binding.title.text = sports.title
            binding.title.transitionName = sports.title
            itemView.setOnClickListener {
                onClickListener.onClick(sports, binding.banner, binding.title)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(
            ItemSportsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sports: Sports = sportsList[position]
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = sportsList.size

    class OnImgClickListener(val clickListener: (Sports, ImageView, TextView) -> Unit) {
        fun onClick(
            sports: Sports,
            iconImageView: ImageView,
            title: TextView
        ) = clickListener(sports, iconImageView, title)
    }

}