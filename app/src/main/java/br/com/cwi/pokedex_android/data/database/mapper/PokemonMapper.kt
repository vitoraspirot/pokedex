package br.com.cwi.pokedex_android.data.database.mapper

import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.domain.entity.Pokemon

fun PokemonEntity.toPokemon() = Pokemon(
    entityId,
    pokemonId,
    name
)

fun Pokemon.toEntity() = PokemonEntity(
    entityId,
    pokemonId,
    name
)

fun PokemonEntity.toListedPokemon() = ListedPokemon(
    pokemonName = name,
    pokemonAddress = "https://cdn.traction.one/pokedex/pokemon/${pokemonId}.png"
)