package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import android.content.Intent
import android.os.Bundle
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.databinding.ActivityPokemonListBinding
import br.com.cwi.pokedex_android.presentation.base.BaseBottomNavigation
import br.com.cwi.pokedex_android.presentation.extension.visibleOrGone
import br.com.cwi.pokedex_android.presentation.feature.pokemondetails.PokemonDetailsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityPokemonListBinding
    override val currentTab: Int = R.id.menu_pokemon_list

    private val viewModel: PokemonListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setUpOnErrorActions()
    }


    override fun getBottomNavigation(): BottomNavigationView = binding.bnBottomNavigation

    private fun setUpViewModel() {

        viewModel.pokemonList.observe(this@PokemonListActivity) { list ->
            val recyclerView = binding.rvPokemonList
            recyclerView.adapter =
                PokemonListAdapter(context = this@PokemonListActivity, list) { listedPokemon ->
                    startActivity(
                        Intent(
                            this@PokemonListActivity,
                            PokemonDetailsActivity::class.java
                        ).putExtra("name", listedPokemon.pokemonName)
                    )
                }
        }

        viewModel.loading.observe(this@PokemonListActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@PokemonListActivity) { hasError ->
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

