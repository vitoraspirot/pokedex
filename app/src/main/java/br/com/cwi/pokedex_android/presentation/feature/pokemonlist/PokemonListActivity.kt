package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.pokedex_android.data.mapper.PokemonListMapper
import br.com.cwi.pokedex_android.data.repository.PokemonListRepositoryImpl
import br.com.cwi.pokedex_android.databinding.ActivityPokemonListBinding
import br.com.cwi.pokedex_android.domain.repository.PokemonListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonListBinding

    private val repository : PokemonListRepository = PokemonListRepositoryImpl(
        PokemonListMapper()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPokemonList()
    }

    private fun setUpPokemonList() {

        CoroutineScope(Dispatchers.Main).launch {
            val pokeList = repository.getPokemonList().pokemonList
            val recyclerView = binding.rvPokemonList

            pokeList.let { list ->
                recyclerView.adapter = PokemonListAdapter(context = this@PokemonListActivity, list)
            }

        }

    }

}

