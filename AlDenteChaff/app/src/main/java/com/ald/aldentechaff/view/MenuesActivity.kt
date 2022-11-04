package com.ald.aldentechaff.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ald.aldentechaff.databinding.ActivityMenuesBinding

class MenuesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuesBinding
    private val btnToSlider by lazy { binding.btnToSlider }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnToSlider.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }


    }
}