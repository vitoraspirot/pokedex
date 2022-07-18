package br.com.cwi.pokedex_android.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(dataModule, presentationModule)