package br.com.cwi.pokedex_android.data.network

import br.com.cwi.pokedex_android.data.entity.PokemonListResponse
import retrofit2.http.GET

const val ENDPOINT_OF_THE_151_POKEMONS_LIST = "pokemon?limit=151&offset=0"

interface PokedexApi {

    @GET(ENDPOINT_OF_THE_151_POKEMONS_LIST)
    suspend fun getPokemonsList(): PokemonListResponse

}