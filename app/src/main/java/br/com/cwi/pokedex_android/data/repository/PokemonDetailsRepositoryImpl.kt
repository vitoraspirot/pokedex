package br.com.cwi.pokedex_android.data.repository

import br.com.cwi.pokedex_android.data.network.mapper.PokemonDetailsMapper
import br.com.cwi.pokedex_android.data.network.PokedexApi
import br.com.cwi.pokedex_android.data.network.RetrofitConfig
import br.com.cwi.pokedex_android.domain.entity.PokemonDetails
import br.com.cwi.pokedex_android.domain.repository.PokemonDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonDetailsRepositoryImpl(
    private val pokeApi: PokedexApi = RetrofitConfig.pokeApiService,
    private val mapper: PokemonDetailsMapper
) : PokemonDetailsRepository {

    override suspend fun getPokemonDetails(name: String): PokemonDetails {
        return withContext(Dispatchers.IO) {
            mapper.toDomain(pokeApi.getPokemonDetails(name))
        }
    }
}