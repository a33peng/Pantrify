package com.example.pantrify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class InventoryActivity : AppCompatActivity() {
    // define button counter for items
    private var countTomato = 0
    private var countLettuce = 0
    private var countCucumber = 0
    private var countOnion = 0
    private var countPotato = 0
    private var countCarrot = 0
    private var countFish = 0
    private var countEgg = 0
    private var countRice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.inventory)

        // define id tags from xml
        val btnTomato = findViewById<Button>(R.id.tomato_counter)
        val btnLettuce = findViewById<Button>(R.id.lettuce_counter)
        val btnCucumber = findViewById<Button>(R.id.cucumber_counter)
        val btnOnion = findViewById<Button>(R.id.onion_counter)
        val btnPotato = findViewById<Button>(R.id.potato_counter)
        val btnCarrot = findViewById<Button>(R.id.carrot_counter)
        val btnEgg = findViewById<Button>(R.id.egg_counter)
        val btnRice = findViewById<Button>(R.id.rice_counter)
        val btnFish = findViewById<Button>(R.id.fish_counter)
        val btnExit = findViewById<ImageView>(R.id.exitButton)

        // render new activity page if exit button is clicked
        btnExit.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // dynamic counter function
        btnTomato.setOnClickListener {
            countTomato++
            btnTomato.text = "$countTomato"
        }

        btnLettuce.setOnClickListener {
            countLettuce++
            btnLettuce.text = "$countLettuce"
        }

        btnCucumber.setOnClickListener {
            countCucumber++
            btnCucumber.text = "$countCucumber"
        }

        btnOnion.setOnClickListener {
            countOnion++
            btnOnion.text = "$countOnion"
        }

        btnPotato.setOnClickListener {
            countPotato++
            btnPotato.text = "$countPotato"
        }

        btnCarrot.setOnClickListener {
            countCarrot++
            btnCarrot.text = "$countCarrot"
        }

        btnEgg.setOnClickListener {
            countEgg++
            btnEgg.text = "$countEgg"
        }

        btnRice.setOnClickListener {
            countRice++
            btnRice.text = "$countRice"
        }

        btnFish.setOnClickListener {
            countFish++
            btnFish.text = "$countFish"
        }
    }
}