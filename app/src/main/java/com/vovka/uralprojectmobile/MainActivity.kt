package com.vovka.uralprojectmobile

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val bottomBar = findViewById<LinearLayout>(R.id.linearLayout10)

        val home = findViewById<ImageView>(R.id.home)
        val document = findViewById<ImageView>(R.id.document)
        val message = findViewById<ImageView>(R.id.message)
        val card = findViewById<ImageView>(R.id.card)
        val profile = findViewById<ImageView>(R.id.profile)

        home.setOnClickListener{
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.glavnayaFragment)
            home.setColorFilter(Color.BLACK)
            document.setColorFilter(getColor(R.color.grey_5))
            message.setColorFilter(getColor(R.color.grey_5))
            card.setColorFilter(getColor(R.color.grey_5))
            profile.setColorFilter(getColor(R.color.grey_5))
        }
        profile.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.profileFragment)
            profile.setColorFilter(Color.BLACK)
            document.setColorFilter(getColor(R.color.grey_5))
            message.setColorFilter(getColor(R.color.grey_5))
            card.setColorFilter(getColor(R.color.grey_5))
            home.setColorFilter(getColor(R.color.grey_5))
        }
        card.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.walletDepositFragment)
            card.setColorFilter(Color.BLACK)
            document.setColorFilter(getColor(R.color.grey_5))
            message.setColorFilter(getColor(R.color.grey_5))
            home.setColorFilter(getColor(R.color.grey_5))
            profile.setColorFilter(getColor(R.color.grey_5))
        }
        message.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.supportFragment)
            message.setColorFilter(Color.BLACK)
            document.setColorFilter(getColor(R.color.grey_5))
            home.setColorFilter(getColor(R.color.grey_5))
            profile.setColorFilter(getColor(R.color.grey_5))
            card.setColorFilter(getColor(R.color.grey_5))
        }
       document.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.historyFragment)
            document.setColorFilter(Color.BLACK)
           message.setColorFilter(getColor(R.color.grey_5))
           home.setColorFilter(getColor(R.color.grey_5))
           profile.setColorFilter(getColor(R.color.grey_5))
           card.setColorFilter(getColor(R.color.grey_5))
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.label){
                "fragment_glavnaya" -> bottomBar.visibility = View.VISIBLE
                "fragment_history" -> bottomBar.visibility = View.VISIBLE
                "SupportFragment" -> bottomBar.visibility = View.VISIBLE
                "WalletDepositFragment" -> bottomBar.visibility = View.VISIBLE
                "fragment_profile" -> bottomBar.visibility = View.VISIBLE
                else -> bottomBar.visibility = View.GONE

            }
            Log.d("ff",destination.label.toString())
        }
    }

}