package com.ald.aldentechaff.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ald.aldentechaff.R
import com.ald.aldentechaff.adapters.SliderAdapter
import com.ald.aldentechaff.databinding.ActivityMainBinding
import com.ald.aldentechaff.model.SliderModel
import com.google.android.material.snackbar.Snackbar
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var backPressedTime: Long = 0

    lateinit var sliderHandler: Handler
    lateinit var sliderAdapter: SliderAdapter
    lateinit var isList:ArrayList<SliderModel>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        isList = ArrayList()
        sliderHandler = Handler()
        sliderAdapter = SliderAdapter(isList,this)

        binding.apply {
            isList.add(SliderModel("Фузилли", R.drawable.dente1))
            isList.add(SliderModel("МорроСпагетти", R.drawable.dente2))
            isList.add(SliderModel("Паппарделле", R.drawable.dente3))

            isList.add(SliderModel("Пенне", R.drawable.dente4))
            isList.add(SliderModel("Тальятелле", R.drawable.dente5))
            isList.add(SliderModel("Феттуччине", R.drawable.dente6))
            isList.add(SliderModel("СалатФарфале", R.drawable.dente7))


            sliderAdapter.notifyDataSetChanged()
            isViewImage.adapter = sliderAdapter
            isViewImage.clipChildren = false
            isViewImage.clipToPadding = false
            isViewImage.offscreenPageLimit = 3

            isViewImage.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer= CompositePageTransformer()

            compositePageTransformer.addTransformer(
                MarginPageTransformer(120)
            )

            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }

            isViewImage.setPageTransformer(compositePageTransformer)
            isViewImage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    sliderHandler.removeCallbacks(sliderRunnable)
                    sliderHandler.postDelayed(sliderRunnable,3500)
                    if (position==isList.size-2){
                        isViewImage.post(runnable)
                    }
                }
            })
        }

    }

    val sliderRunnable = Runnable {
        binding.isViewImage.currentItem = binding.isViewImage.currentItem +1
    }

    @SuppressLint("NotifyDataSetChanged")
    val runnable = Runnable {
        isList.addAll(isList)
        sliderAdapter.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable,3500)
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishAffinity()
        } else {
            Snackbar.make(
                this.findViewById(android.R.id.content),
                "Дважды нажмите, чтобы выйти", Snackbar.LENGTH_LONG)
                .show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}