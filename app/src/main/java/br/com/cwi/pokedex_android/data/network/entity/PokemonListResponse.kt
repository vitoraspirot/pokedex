package br.com.cwi.pokedex_android.data.network.entity

import com.squareup.moshi.Json

data class PokemonListResponse(
    @Json(name = "count") val totalAmountOfPokemons: Int,
    @Json(name = "next") val nextList: String?,
    @Json(name = "previous") val previousList: String?,
    @Json(name = "results") val pokemonList: List<PokeApiBaseInfo>
)