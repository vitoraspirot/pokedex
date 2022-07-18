package br.com.cwi.pokedex_android.data.network.mapper

import br.com.cwi.pokedex_android.data.network.entity.PokeApiBaseInfo
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon

class ListedPokemonMapper: DomainMapper<PokeApiBaseInfo, ListedPokemon> {

    override fun toDomain(from: PokeApiBaseInfo) = ListedPokemon(
        pokemonAddress = from.url,
        pokemonName = from.name
    )

    override fun toDomain(from: List<PokeApiBaseInfo>) = from.map {
        toDomain(it)
    }

}