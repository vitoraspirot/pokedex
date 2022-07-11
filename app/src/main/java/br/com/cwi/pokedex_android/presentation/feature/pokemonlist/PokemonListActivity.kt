package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.pokedex_android.databinding.ActivityPokemonListBinding

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding

    private val viewModel = PokemonListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.pokemonList.observe(this@PokemonListActivity) { list ->
            val recyclerView = binding.rvPokemonList
            recyclerView.adapter = PokemonListAdapter(context = this@PokemonListActivity, list)
        }
        viewModel.fetchPokemonList()
    }

}

