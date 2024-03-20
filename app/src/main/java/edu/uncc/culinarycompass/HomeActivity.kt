package edu.uncc.culinarycompass

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.carousel.CarouselSnapHelper
import edu.uncc.culinarycompass.adapter.CarouselAdapter
import edu.uncc.culinarycompass.adapter.MainCategoryAdapter
import edu.uncc.culinarycompass.entities.Recipes
import edu.uncc.culinarycompass.models.ImageItem
import java.util.UUID

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()
    private lateinit var viewpager2 : ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8,0,8,0)
    }

    private lateinit var carouselRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        viewpager2 = findViewById<ViewPager2>(R.id.carouselRecyclerView)


        // this is just sample data
        // we can actually use a full url instead, that will call the API for the image
        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.pancakes
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.paella
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.corndogs
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.grilled_cheese
            )
        )

        val carouselAdapter = CarouselAdapter()
        viewpager2.adapter = carouselAdapter
        carouselAdapter.submitList(imageList)

        val slideDotll = findViewById<LinearLayout>(R.id.slideDots)
        val dotsImage = Array(imageList.size) { ImageView(this) }

        dotsImage.forEach{
            it.setImageResource(
                R.drawable.non_active_dot
            )
            slideDotll.addView(it, params)
        }
        dotsImage[0].setImageResource(R.drawable.active_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                   if (position == index){
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                   }else{
                       imageView.setImageResource(R.drawable.non_active_dot)
                   }
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListener)

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

    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }

}