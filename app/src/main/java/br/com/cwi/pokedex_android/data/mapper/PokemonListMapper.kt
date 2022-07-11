package br.com.cwi.pokedex_android.data.mapper

import br.com.cwi.pokedex_android.data.entity.PokemonListResponse
import br.com.cwi.pokedex_android.domain.entity.PokemonList

class PokemonListMapper {
    fun toDomain(from: PokemonListResponse) = PokemonList(
        totalAmountOfPokemons = from.totalAmountOfPokemons,
        nextList = from.nextList,
        previousList = from.previousList,
        pokemonList = ListedPokemonMapper().toDomain(from.pokemonList)
    )

}