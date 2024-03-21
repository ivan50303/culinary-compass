package edu.uncc.culinarycompass.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import edu.uncc.culinarycompass.R
import edu.uncc.culinarycompass.RecipeActivity
import edu.uncc.culinarycompass.entities.Recipes
import android.content.Context


class ProfileFavoritesAdapter: RecyclerView.Adapter<ProfileFavoritesAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<Recipes>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tv_dish_name = itemView.findViewById<TextView>(R.id.tv_dish_name)

    }

    fun setData(arrData : List<Recipes>){
        arrMainCategory = arrData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_card,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.tv_dish_name.text = arrMainCategory[position].dishName

    }
}