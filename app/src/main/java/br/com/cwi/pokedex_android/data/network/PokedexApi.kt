package br.com.cwi.pokedex_android.data.network

import br.com.cwi.pokedex_android.data.network.entity.PokemonDetailsResponse
import br.com.cwi.pokedex_android.data.network.entity.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApi {

    @GET("pokemon?limit=151&offset=0")
    suspend fun getPokemonsList(): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String) : PokemonDetailsResponse

}

