package com.dev_candra.localization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

    }

    private fun initToolbar(){
        supportActionBar?.title = "Candra Julius Sinaga"
        supportActionBar?.subtitle = "Localization"
        changeBahasa()
    }

    private fun changeBahasa(){
        val pokeCount = 3
        val hello = resources.getString(R.string.hello_world,"Candra Julius Sinaga",pokeCount,"Julius")
        tv_hello.text = hello

        val songCount = 5
        val pluralText = resources.getQuantityString(R.plurals.numberOfSongsAvailable,songCount,songCount)
        tv_plural.text = pluralText

        tv_xliff.text = resources.getString(R.string.app_homeurl)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.change_bahasa){
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }
        return super.onOptionsItemSelected(item)
    }
}