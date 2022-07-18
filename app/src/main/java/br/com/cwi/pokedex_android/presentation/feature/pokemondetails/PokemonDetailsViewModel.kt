package br.com.cwi.pokedex_android.presentation.feature.pokemondetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.pokedex_android.domain.entity.PokemonDetails
import br.com.cwi.pokedex_android.domain.mapper.toPokemonEntity
import br.com.cwi.pokedex_android.domain.repository.HallOfFameRepository
import br.com.cwi.pokedex_android.domain.repository.PokemonDetailsRepository
import br.com.cwi.pokedex_android.presentation.base.BaseViewModel

class PokemonDetailsViewModel(
    private val repository: PokemonDetailsRepository,
    private val local: HallOfFameRepository
) : BaseViewModel() {

    private val _pokemonDetails = MutableLiveData<PokemonDetails>()
    val pokemonDetails: LiveData<PokemonDetails> = _pokemonDetails

    fun fetchPokemonDetails(name: String) {
        launch {
            val pokeDetails = repository.getPokemonDetails(name)
            _pokemonDetails.postValue(pokeDetails)
        }
    }

    fun inHallOfFame(pokeId: Int) = local.findPokemon(pokeId) != null

    fun addToHallOfFame(pokemonDetails: PokemonDetails) {
        local.saveHallOfFame(pokemonDetails.toPokemonEntity())
    }

    fun removeFromHallOfFame(pokemonDetails: PokemonDetails){
        local.removeHallOfFame(pokemonDetails.toPokemonEntity())
    }

}