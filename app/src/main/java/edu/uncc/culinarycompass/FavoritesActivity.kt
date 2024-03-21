package edu.uncc.culinarycompass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navBar)
        bottomNavigationView.selectedItemId = R.id.favorites
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

        

        supportActionBar?.hide()
    }
}