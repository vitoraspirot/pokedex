package br.com.cwi.pokedex_android.domain.entity

class PokemonList(
    val totalAmountOfPokemons: Int,
    val nextList: String?,
    val previousList: String?,
    val pokemonList: List<ListedPokemon>
)