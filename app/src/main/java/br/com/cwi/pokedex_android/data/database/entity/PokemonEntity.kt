package br.com.cwi.pokedex_android.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PokemonEntity(
    @PrimaryKey val entityId: Int,
    val pokemonId: Int,
    val name: String,

    )