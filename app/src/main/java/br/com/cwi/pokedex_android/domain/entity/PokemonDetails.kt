package br.com.cwi.pokedex_android.domain.entity

import br.com.cwi.pokedex_android.data.network.entity.PokeStats
import br.com.cwi.pokedex_android.data.network.entity.PokeTypes
import br.com.cwi.pokedex_android.data.network.entity.PokemonAbility

class PokemonDetails(
    val pokemonId: Int,
    val abilities: List<PokemonAbility>,
    val height: Int,
    val weight: Int,
    val name: String,
    val stats: List<PokeStats>,
    val types: List<PokeTypes>,
)