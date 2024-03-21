package edu.uncc.culinarycompass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.uncc.culinarycompass.adapter.MainCategoryAdapter
import edu.uncc.culinarycompass.adapter.ProfileFavoritesAdapter
import edu.uncc.culinarycompass.entities.Recipes

class ProfileActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var profileFavoritesAdapter = ProfileFavoritesAdapter()
    var ignoreSelection = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navBar)
        bottomNavigationView.itemBackground = null
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.home ->{
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.search ->{
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.favorites ->{
                    startActivity(Intent(this, FavoritesActivity::class.java))
                    true
                }
                else -> false
            }
        }

        val editProfileBtn = findViewById<Button>(R.id.editProfileBtn)
        editProfileBtn.setOnClickListener {
            var intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }

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