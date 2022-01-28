package com.tochukwu.futofood.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tochukwu.futofood.databinding.FruitsContentBinding
import com.tochukwu.futofood.domain.model.Fruit
import javax.inject.Inject

class FruitsAdapter  : androidx.recyclerview.widget.ListAdapter<Fruit, FruitsAdapter.FruitsViewHolder>(DIFF_COMPARATOR) {
// class FruitsAdapter @Inject constructor() : androidx.recyclerview.widget.ListAdapter<Fruit, FruitsAdapter.FruitsViewHolder>(DIFF_COMPARATOR)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val binding = FruitsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null){
            holder.bind(currentItem)
        }
    }

    inner class FruitsViewHolder(private val binding: FruitsContentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(app: Fruit){

            binding.apply{
                name.text = app.name
                family.text = app.family
            }
        }

    }


    companion object {
        private val DIFF_COMPARATOR = object: DiffUtil.ItemCallback<Fruit>(){
            override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
                return oldItem == newItem
            }
        }
    }
}

/**

inner class PosterViewHolder(private val binding: CharactersRowBinding) : RecyclerView.ViewHolder(binding.root){
fun bind(app: PosterDtoItem){
binding.apply{

paymentName.text = app.name
Glide.with(itemView).load(app.poster).into(logo)

setOnClickListener(app)

}
}

private fun setOnClickListener(app: PosterDtoItem){
binding.detailItem.setOnClickListener { view ->
navigateToDetail(app, view)
}
}

private fun navigateToDetail(app: PosterDtoItem, view: View) {
val directions = CharacterFragmentDirections.actionCharacterFragmentToDisneyDetail(app)
view.findNavController().navigate(directions)
}

**/