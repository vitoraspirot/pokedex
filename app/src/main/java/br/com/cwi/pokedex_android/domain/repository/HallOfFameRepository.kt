package br.com.cwi.pokedex_android.domain.repository

import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity

interface HallOfFameRepository {
    fun getHallOfFame(): List<PokemonEntity>?
    fun saveHallOfFame(pokemon: PokemonEntity)
    fun removeHallOfFame(pokemon: PokemonEntity)
    fun findPokemon(pokeId: Int) : PokemonEntity?
}