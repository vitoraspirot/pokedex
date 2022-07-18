package br.com.cwi.pokedex_android.domain.repository

import br.com.cwi.pokedex_android.domain.entity.PokemonDetails

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(name: String): PokemonDetails
}