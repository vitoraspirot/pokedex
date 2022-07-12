package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.pokedex_android.data.mapper.PokemonListMapper
import br.com.cwi.pokedex_android.data.repository.PokemonListRepositoryImpl
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.domain.repository.PokemonListRepository
import br.com.cwi.pokedex_android.presentation.base.BaseViewModel

class PokemonListViewModel : BaseViewModel() {

    private val _pokemonList = MutableLiveData<List<ListedPokemon>>()
    val pokemonList: LiveData<List<ListedPokemon>> = _pokemonList

    private val repository: PokemonListRepository = PokemonListRepositoryImpl(
        PokemonListMapper()
    )

    fun fetchPokemonList() {
        launch {
            val pokeList = repository.getPokemonList().pokemonList
            _pokemonList.postValue(pokeList)
        }
    }

}