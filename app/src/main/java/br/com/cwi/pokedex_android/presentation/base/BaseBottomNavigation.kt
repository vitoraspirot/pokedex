package br.com.cwi.pokedex_android.presentation.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.presentation.feature.halloffame.HallOfFameActivity
import br.com.cwi.pokedex_android.presentation.feature.pokemonlist.PokemonListActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {

        getBottomNavigation().setOnItemSelectedListener {
            if (!isCurrentTab(it.itemId)) when (it.itemId) {
                R.id.menu_pokemon_list -> {
                    val intent = Intent(this, PokemonListActivity::class.java)
                    startActivity(intent)
                }
                R.id.menu_hall_of_fame -> {
                    val intent = Intent(this, HallOfFameActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

    private fun isCurrentTab(itemId: Int): Boolean {
        return itemId == this.currentTab
    }

}