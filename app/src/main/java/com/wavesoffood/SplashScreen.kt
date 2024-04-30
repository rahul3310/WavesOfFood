package com.wavesoffood

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.wavesoffood.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (BuildConfig.BUILD_IDENTIFIER == "admin"){
            binding.appDescripsion.text = "Admin Dashboard"
            binding.appDescripsion.setTextColor(getColor(R.color.green))
        }else{
            binding.appDescripsion.text = getString(R.string.deliver_favorite_food)
            binding.appDescripsion.setTextColor(getColor(R.color.black))
        }
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}