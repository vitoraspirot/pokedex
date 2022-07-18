package br.com.cwi.pokedex_android.di

import br.com.cwi.pokedex_android.presentation.feature.halloffame.HallOfFameViewModel
import br.com.cwi.pokedex_android.presentation.feature.pokemondetails.PokemonDetailsViewModel
import br.com.cwi.pokedex_android.presentation.feature.pokemonlist.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        PokemonListViewModel(get())
    }

    viewModel {
        PokemonDetailsViewModel(get(), get())
    }

    viewModel {
        HallOfFameViewModel(get())
    }

}