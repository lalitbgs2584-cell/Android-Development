package com.example.basic_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.basic_app.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = "https://images.unsplash.com/photo-1759239934518-5c69b744ff91" // any image URL

        // Load image from internet
        Glide.with(this)
            .load(imageUrl)
            .error(R.drawable.img2)       // optional: shows if URL fails
            .into(binding.image)

        // Change image on button click
        var isFlag: Boolean = false
        binding.btn.setOnClickListener {
            if(isFlag){
                val newUrl = "https://images.unsplash.com/photo-1759130087819-db88758c3fab"
                Glide.with(this)
                    .load(newUrl)
                    .into(binding.image)
            }
            else{
                val newUrl = "https://images.unsplash.com/photo-1759239934518-5c69b744ff91"
                Glide.with(this)
                    .load(newUrl)
                    .into(binding.image)
            }
            isFlag = !isFlag
        }
    }
}
