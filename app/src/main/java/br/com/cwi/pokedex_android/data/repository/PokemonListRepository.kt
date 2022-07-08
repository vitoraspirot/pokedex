package br.com.cwi.pokedex_android.data.repository

import br.com.cwi.pokedex_android.data.entity.PokemonListResponse
import br.com.cwi.pokedex_android.data.network.PokedexApi
import br.com.cwi.pokedex_android.data.network.RetrofitConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListRepository() {

    private val pokeApi: PokedexApi = RetrofitConfig.pokeApiService

    suspend fun getPokemonList(): PokemonListResponse {
        return withContext(Dispatchers.IO) {
            pokeApi.getPokemonsList()
        }
    }
}

