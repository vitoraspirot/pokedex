package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.domain.repository.PokemonListRepository
import br.com.cwi.pokedex_android.presentation.base.BaseViewModel

class PokemonListViewModel(
    private val repository : PokemonListRepository
) : BaseViewModel() {

    private val _pokemonList = MutableLiveData<List<ListedPokemon>>()
    val pokemonList: LiveData<List<ListedPokemon>> = _pokemonList

    fun fetchPokemonList() {
        launch {
            val pokeList = repository.getPokemonList().pokemonList
            _pokemonList.postValue(pokeList)
        }
    }

}