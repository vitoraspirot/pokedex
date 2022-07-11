package br.com.cwi.pokedex_android.presentation.feature.pokemonlist.viewholder

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.databinding.ItemListedPokemonBinding
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import com.bumptech.glide.Glide

class ListedPokemonViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    private val tvListedPokemonNumber = ItemListedPokemonBinding.bind(item).tvListedPokemonNumber
    private val tvListedPokemonName = ItemListedPokemonBinding.bind(item).tvListedPokemonName
    private val ivListedPokemonSprite = ItemListedPokemonBinding.bind(item).ivListedPokemonSprite

    @SuppressLint("SetTextI18n")
    fun bind(context: Context, item: ListedPokemon, pokemonId: Int) {

        tvListedPokemonNumber.text = "#${pokemonId}"

        val firstLetter = item.pokemonName[0].uppercase()
        val listedPokemonName = firstLetter + item.pokemonName.substring(1, item.pokemonName.length)
        tvListedPokemonName.text = listedPokemonName

        val spriteUrl = "https://cdn.traction.one/pokedex/pokemon/${pokemonId}.png"
        Glide.with(context).load(spriteUrl).placeholder(R.drawable.pokemon_placeholder)
            .into(ivListedPokemonSprite)
    }

}