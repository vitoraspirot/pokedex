package br.com.cwi.pokedex_android.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity

@Dao
interface PokemonDao {

    @Insert
    fun add(entity: PokemonEntity)

    @Delete
    fun delete(entity: PokemonEntity)

    @Query("select * from PokemonEntity")
    fun getAll(): List<PokemonEntity>

    @Query("select * from PokemonEntity where pokemonId=:pokeId")
    fun findPokemon(pokeId: Int): PokemonEntity
}