package br.com.cwi.pokedex_android.di

import br.com.cwi.pokedex_android.data.database.AppDatabase
import br.com.cwi.pokedex_android.data.network.mapper.PokemonDetailsMapper
import br.com.cwi.pokedex_android.data.network.mapper.PokemonListMapper
import br.com.cwi.pokedex_android.data.network.RetrofitConfig
import br.com.cwi.pokedex_android.data.repository.HallOfFameRepositoryImpl
import br.com.cwi.pokedex_android.data.repository.PokemonDetailsRepositoryImpl
import br.com.cwi.pokedex_android.data.repository.PokemonListRepositoryImpl
import br.com.cwi.pokedex_android.domain.repository.HallOfFameRepository
import br.com.cwi.pokedex_android.domain.repository.PokemonDetailsRepository
import br.com.cwi.pokedex_android.domain.repository.PokemonListRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.pokeApiService }
    single { PokemonListMapper() }
    single { PokemonDetailsMapper() }
    single { AppDatabase.create(androidApplication()) }

    factory<HallOfFameRepository> { HallOfFameRepositoryImpl(get()) }
    factory<PokemonDetailsRepository> { PokemonDetailsRepositoryImpl(get(), get()) }
    factory<PokemonListRepository> { PokemonListRepositoryImpl(get(), get()) }
}