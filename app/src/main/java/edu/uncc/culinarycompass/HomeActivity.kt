package edu.uncc.culinarycompass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uncc.culinarycompass.adapter.MainCategoryAdapter
import edu.uncc.culinarycompass.entities.Recipes

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        val rv_main_category = findViewById<RecyclerView>(R.id.rv_main_category)
        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Pizza"))
        arrMainCategory.add(Recipes(3, "Pasta"))
        arrMainCategory.add(Recipes(4, "Cupcake"))

        mainCategoryAdapter.setData(arrMainCategory)

        rv_main_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_main_category.adapter = mainCategoryAdapter
    }

}