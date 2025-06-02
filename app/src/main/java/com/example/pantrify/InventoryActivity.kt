package com.example.pantrify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit


class InventoryActivity : AppCompatActivity() {
    // define shared preference for accessing/modifying data through an editor object
    private val PREFSNAME  = "InventoryPrefs"

    private fun saveCounter(key: String, value: Int){
        val prefs= getSharedPreferences(PREFSNAME, MODE_PRIVATE )
        prefs.edit { putInt(key, value) }
    }

    // return integer value of inventory
    private fun updateCounter(key: String):Int{
        val prefs = getSharedPreferences(PREFSNAME,MODE_PRIVATE)
        return prefs.getInt(key, 0)
    }

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

        // load saved values
        countTomato = updateCounter("tomato")
        countLettuce = updateCounter("lettuce")
        countCucumber = updateCounter("cucumber")
        countOnion = updateCounter("onion")
        countPotato = updateCounter("potato")
        countCarrot = updateCounter("carrot")
        countEgg = updateCounter("egg")
        countRice = updateCounter("rice")
        countFish = updateCounter("fish")

        // set initial counter value for buttons
        btnTomato.text = "$countTomato"
        btnLettuce.text = "$countLettuce"
        btnCucumber.text = "$countCucumber"
        btnOnion.text = "$countOnion"
        btnPotato.text = "$countPotato"
        btnCarrot.text = "$countCarrot"
        btnEgg.text = "$countEgg"
        btnRice.text = "$countRice"
        btnFish.text = "$countFish"

        // render new activity page if exit button is clicked
        btnExit.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // dynamic counter function
        btnTomato.setOnClickListener {
            countTomato++
            btnTomato.text = "$countTomato"
            saveCounter("tomato",countTomato)
        }

        btnLettuce.setOnClickListener {
            countLettuce++
            btnLettuce.text = "$countLettuce"
            saveCounter("lettuce",countLettuce)
        }

        btnCucumber.setOnClickListener {
            countCucumber++
            btnCucumber.text = "$countCucumber"
            saveCounter("cucumber", countCucumber)
        }

        btnOnion.setOnClickListener {
            countOnion++
            btnOnion.text = "$countOnion"
            saveCounter("onion", countOnion)
        }

        btnPotato.setOnClickListener {
            countPotato++
            btnPotato.text = "$countPotato"
            saveCounter("potato", countPotato)
        }

        btnCarrot.setOnClickListener {
            countCarrot++
            btnCarrot.text = "$countCarrot"
            saveCounter("carrot", countCarrot)
        }

        btnEgg.setOnClickListener {
            countEgg++
            btnEgg.text = "$countEgg"
            saveCounter("egg", countEgg)
        }

        btnRice.setOnClickListener {
            countRice++
            btnRice.text = "$countRice"
            saveCounter("rice", countRice)
        }

        btnFish.setOnClickListener {
            countFish++
            btnFish.text = "$countFish"
            saveCounter("fish", countFish)
        }
    }
}