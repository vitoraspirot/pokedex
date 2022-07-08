package br.com.cwi.pokedex_android.data.entity

import com.squareup.moshi.Json

data class ListedPokemonResponse(
    @Json(name = "name") val pokemonName: String,
    @Json(name = "url") val pokemonAddress: String
)