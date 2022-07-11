package br.com.cwi.pokedex_android.data.mapper

import br.com.cwi.pokedex_android.data.entity.ListedPokemonResponse
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon

class ListedPokemonMapper: DomainMapper<ListedPokemonResponse, ListedPokemon> {

    override fun toDomain(from: ListedPokemonResponse) = ListedPokemon(
        pokemonAddress = from.pokemonAddress,
        pokemonName = from.pokemonName
    )

    override fun toDomain(from: List<ListedPokemonResponse>) = from.map {
        toDomain(it)
    }

}