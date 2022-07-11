package br.com.cwi.pokedex_android.domain.repository

import br.com.cwi.pokedex_android.domain.entity.PokemonList

interface PokemonListRepository {
    suspend fun getPokemonList(): PokemonList
}