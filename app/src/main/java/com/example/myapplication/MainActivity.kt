package com.example.myapplication

import android.media.MediaDrm.LogMessage
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem

import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("REGX", "Alphanum : LETTERS : " + regExLetter("LETTERS").toString())
        Log.d("REGX", "Alphanum : LETT%RS : " + regExLetter("LETT%RS").toString())

        Log.d("REGX", "Digit : 8 : " + regExDigit("8").toString())
        Log.d("REGX", "Digit : 123 : " + regExDigit("123").toString())

        Log.d("REGX", "Number : 0786127822 : " + regExNumber("0786127822").toString())
        Log.d("REGX", "Number : +33786127822 : " + regExNumber("+33786127822").toString())

        Log.d("REGX", "Mail : olivier@inkos.fr.com.y.aaa : " + regExMail("olivier@inkos.fr").toString())
        Log.d("REGX", "Mail : olivier@@inkOS,FR : " + regExMail("olivier@@inkOS,FR").toString())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun regExLetter(s : String): Boolean
    {
        val pattern = Regex("[[:alnum:]]+")
        return pattern.matches(s)
    }

    fun regExNumber(s: String): Boolean{
        val pattern = Regex("[\\d]{10}+")
        return pattern.matches(s)
    }

    fun regExDigit(s: String): Boolean{
        val pattern = Regex("[\\d]")
        return pattern.matches(s)
    }

    fun regExMail(s: String): Boolean{
        val pattern = Regex("^[\\w\\-\\.]+@(|\\w-]+\\.)+.([\\w\\-\\.])+")
        return pattern.matches(s)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }



}