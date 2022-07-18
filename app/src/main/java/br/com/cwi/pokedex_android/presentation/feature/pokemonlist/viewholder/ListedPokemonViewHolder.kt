package br.com.cwi.pokedex_android.presentation.feature.pokemonlist.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.databinding.ItemListedPokemonBinding
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.domain.entity.Pokemon
import br.com.cwi.pokedex_android.presentation.extension.firstLetterUpperCase
import com.bumptech.glide.Glide

class ListedPokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvListedPokemonNumber =
        ItemListedPokemonBinding.bind(itemView).tvListedPokemonNumber
    private val tvListedPokemonName = ItemListedPokemonBinding.bind(itemView).tvListedPokemonName
    private val ivListedPokemonSprite =
        ItemListedPokemonBinding.bind(itemView).ivListedPokemonSprite

    fun bind(
        context: Context,
        listedPokemon: ListedPokemon,
        pokemonId: Int,
        onItemClicked: (ListedPokemon) -> Unit
    ) {

        tvListedPokemonNumber.text = pokemonId.toString()
        tvListedPokemonName.text = listedPokemon.pokemonName.firstLetterUpperCase()

        Glide.with(context)
            .load(getSpriteUrl(pokemonId))
            .placeholder(R.drawable.pokemon_placeholder)
            .into(ivListedPokemonSprite)

        itemView.setOnClickListener {
            onItemClicked(listedPokemon)
        }
    }

    private fun getSpriteUrl(pokemonId: Int) =
        "https://cdn.traction.one/pokedex/pokemon/${pokemonId}.png"

}