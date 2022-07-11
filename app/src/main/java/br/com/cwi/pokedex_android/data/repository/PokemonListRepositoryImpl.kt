package br.com.cwi.pokedex_android.data.repository

import br.com.cwi.pokedex_android.data.mapper.PokemonListMapper
import br.com.cwi.pokedex_android.data.network.PokedexApi
import br.com.cwi.pokedex_android.data.network.RetrofitConfig
import br.com.cwi.pokedex_android.domain.entity.PokemonList
import br.com.cwi.pokedex_android.domain.repository.PokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListRepositoryImpl(private val mapper: PokemonListMapper) : PokemonListRepository {

    private val pokeApi: PokedexApi = RetrofitConfig.pokeApiService

    override suspend fun getPokemonList(): PokemonList {
        return withContext(Dispatchers.IO) {
            mapper.toDomain(pokeApi.getPokemonsList())
        }
    }
}

