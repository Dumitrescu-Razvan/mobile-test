package com.example.enviromentapp.UI


import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.enviromentapp.R
import com.example.enviromentapp.databinding.ActivityMainBinding
import com.example.enviromentapp.Data.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var repository: ActivityRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = ActivityRepo()


        val activity1 = EnvActivity("Driving", "Carbon Emission", 30f, "2021-10-01", "High")
        val activity2 = EnvActivity("Cycling", "Carbon Emission", 10f, "2021-10-02", "Low")
        val activity3 = EnvActivity("Filled Pool", "Water Waste", 5f, "2021-10-03", "Low")
        val activity4 = EnvActivity("Recycling", "Carbon Emission", 0f, "2021-10-04", "Low")
        val activity5 = EnvActivity("Driving", "Carbon Emission", 30f, "2021-10-05", "High")
        val activity6 = EnvActivity("Cycling", "Carbon Emission", 10f, "2021-10-06", "Low")


        repository.addActivity(activity1)
        repository.addActivity(activity2)
        repository.addActivity(activity3)
        repository.addActivity(activity4)
        repository.addActivity(activity5)
        repository.addActivity(activity6)


        //print the activities
        for (activity in repository.activities){
            println(activity)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
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