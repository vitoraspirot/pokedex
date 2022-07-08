package br.com.cwi.pokedex_android.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"

object RetrofitConfig {

    val pokeApiService: PokedexApi = Retrofit.Builder()
        .baseUrl(POKE_API_BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        )
        .build().create(PokedexApi::class.java)

}