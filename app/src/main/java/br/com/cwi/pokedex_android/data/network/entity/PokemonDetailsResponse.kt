package br.com.cwi.pokedex_android.data.network.entity

class PokemonDetailsResponse(
    val abilities: List<PokemonAbility>,
    val height: Int,
    val weight: Int,
    val id: Int,
    val name: String,
    val stats: List<PokeStats>,
    val types: List<PokeTypes>
)
