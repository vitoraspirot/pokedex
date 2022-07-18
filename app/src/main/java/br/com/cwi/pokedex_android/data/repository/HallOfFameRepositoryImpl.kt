package br.com.cwi.pokedex_android.data.repository

import br.com.cwi.pokedex_android.data.database.AppDatabase
import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.domain.repository.HallOfFameRepository

private const val MAX_POKEMONS_IN_HALL_OF_FAME = 6

class HallOfFameRepositoryImpl(
    appDatabase: AppDatabase
) : HallOfFameRepository {

    private val dao = appDatabase.getPokemonDao()

    override fun getHallOfFame(): List<PokemonEntity> = dao.getAll()

    override fun saveHallOfFame(pokemon: PokemonEntity) {
        if(dao.getAll().size < MAX_POKEMONS_IN_HALL_OF_FAME) {
            dao.add(pokemon)
        }
    }

    override fun removeHallOfFame(pokemon: PokemonEntity) {
        dao.delete(pokemon)
    }

    override fun findPokemon(pokeId: Int): PokemonEntity {
        return dao.findPokemon(pokeId)
    }
}