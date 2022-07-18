package br.com.cwi.pokedex_android.data.network.mapper

import br.com.cwi.pokedex_android.data.network.entity.PokemonDetailsResponse
import br.com.cwi.pokedex_android.domain.entity.PokemonDetails

class PokemonDetailsMapper : DomainMapper<PokemonDetailsResponse, PokemonDetails> {
    override fun toDomain(from: PokemonDetailsResponse) = PokemonDetails(
        abilities = from.abilities,
        height = from.height,
        weight = from.weight,
        pokemonId = from.id,
        name = from.name,
        stats = from.stats,
        types = from.types
    )

    override fun toDomain(from: List<PokemonDetailsResponse>) = from.map {
        toDomain(it)
    }
}