package com.example.rtcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val btnBrowseMenu = findViewById<Button>(R.id.btnBrowseMenu)
        val btnPopularPlatters = findViewById<LinearLayout>(R.id.btnPopularPlatters)
        val btnPopularPackages = findViewById<LinearLayout>(R.id.btnPopularPackages)

        val navHome = findViewById<TextView>(R.id.navHome)
        val navMenu = findViewById<TextView>(R.id.navMenu)
        val navCart = findViewById<TextView>(R.id.navCart)
        val navOrders = findViewById<TextView>(R.id.navOrders)
        val navProfile = findViewById<TextView>(R.id.navProfile)

        /*
         * Menu navigation will be connected
         */

        btnBrowseMenu.setOnClickListener {

            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }

        btnPopularPlatters.setOnClickListener {

            Toast.makeText(
                this,
                "Platters selected.",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnPopularPackages.setOnClickListener {

            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }

        navHome.setOnClickListener {
            // Already on Home
        }

        navMenu.setOnClickListener {

            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }

        navCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        navOrders.setOnClickListener {

            Toast.makeText(
                this,
                "Orders coming soon.",
                Toast.LENGTH_SHORT
            ).show()
        }

        navProfile.setOnClickListener {

            Toast.makeText(
                this,
                "Profile coming next.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}