package br.com.cwi.pokedex_android.domain.mapper

import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.domain.entity.PokemonDetails

fun PokemonDetails.toPokemonEntity() = PokemonEntity(
    pokemonId = pokemonId,
    name = name,
    entityId = pokemonId
)