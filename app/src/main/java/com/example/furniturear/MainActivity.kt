package com.example.furniturear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.furniturear.helpers.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentFrame, MainFragment(), "AR")
                .addToBackStack("AR")
                .commit()
        }
    }
}