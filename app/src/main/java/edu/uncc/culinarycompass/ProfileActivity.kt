package edu.uncc.culinarycompass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uncc.culinarycompass.adapter.MainCategoryAdapter
import edu.uncc.culinarycompass.adapter.ProfileFavoritesAdapter
import edu.uncc.culinarycompass.entities.Recipes

class ProfileActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var profileFavoritesAdapter = ProfileFavoritesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.hide()

        val rv_favorites = findViewById<RecyclerView>(R.id.rv_favorites)
        arrMainCategory.add(Recipes(1, "Creamy Garlic Pasta"))
        arrMainCategory.add(Recipes(2, "Creamy Garlic Pasta"))
        arrMainCategory.add(Recipes(3, "Creamy Garlic Pasta"))
        arrMainCategory.add(Recipes(4, "Creamy Garlic Pasta"))

        profileFavoritesAdapter.setData(arrMainCategory)

        rv_favorites.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_favorites.adapter = profileFavoritesAdapter
    }
}