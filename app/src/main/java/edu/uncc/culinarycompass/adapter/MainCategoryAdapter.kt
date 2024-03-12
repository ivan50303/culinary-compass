package edu.uncc.culinarycompass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.uncc.culinarycompass.R
import edu.uncc.culinarycompass.entities.Recipes


class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<Recipes>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tv_dish_name = itemView.findViewById<TextView>(R.id.tv_dish_name)
    }

    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.tv_dish_name.text = arrMainCategory[position].dishName
    }
}