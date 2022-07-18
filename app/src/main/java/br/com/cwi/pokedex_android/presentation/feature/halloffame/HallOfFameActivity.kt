package br.com.cwi.pokedex_android.presentation.feature.halloffame

import android.content.Intent
import android.os.Bundle
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.databinding.ActivityHallOfFameBinding
import br.com.cwi.pokedex_android.presentation.base.BaseBottomNavigation
import br.com.cwi.pokedex_android.presentation.extension.visibleOrGone
import br.com.cwi.pokedex_android.presentation.feature.pokemondetails.PokemonDetailsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HallOfFameActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityHallOfFameBinding
    override val currentTab: Int = R.id.menu_hall_of_fame

    private val viewModel: HallOfFameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHallOfFameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setUpOnErrorActions()

    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bnBottomNavigation

    private fun setUpViewModel() {

        viewModel.pokemonList.observe(this@HallOfFameActivity) { list ->

            binding.tvNoPokemons.visibleOrGone(list.isEmpty())

            val recyclerView = binding.rvPokemonList
            recyclerView.adapter =
                HallOfFameAdapter(context = this@HallOfFameActivity, list) { listedPokemon ->
                    startActivity(
                        Intent(
                            this@HallOfFameActivity,
                            PokemonDetailsActivity::class.java
                        ).putExtra(
                            "name", listedPokemon.pokemonName
                        )
                    )
                }

        }

        viewModel.loading.observe(this@HallOfFameActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@HallOfFameActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchPokemonList()

    }

    private fun setUpOnErrorActions() {
        binding.viewError.buttonError.setOnClickListener {
            setUpViewModel()
        }
    }
}