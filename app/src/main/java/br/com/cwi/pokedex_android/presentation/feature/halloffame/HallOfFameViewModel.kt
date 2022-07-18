package br.com.cwi.pokedex_android.presentation.feature.halloffame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.domain.repository.HallOfFameRepository
import br.com.cwi.pokedex_android.presentation.base.BaseViewModel

class HallOfFameViewModel(private val repository: HallOfFameRepository): BaseViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonEntity>>()
    val pokemonList: LiveData<List<PokemonEntity>> = _pokemonList

    fun fetchPokemonList() {
        launch {
            val pokeList = repository.getHallOfFame()
            _pokemonList.postValue(pokeList)
        }
    }

}