package br.com.cwi.pokedex_android.presentation.feature.pokemon_list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.data.entity.ListedPokemonResponse
import br.com.cwi.pokedex_android.databinding.ItemListedPokemonBinding
import com.bumptech.glide.Glide

class PokemonListAdapter(val context: Context, private val list: List<ListedPokemonResponse>) :
    RecyclerView.Adapter<ListedPokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListedPokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_listed_pokemon, parent, false)
        return ListedPokemonViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ListedPokemonViewHolder, position: Int) {

        val item = list[position]
        val pokemonId = position + 1

        holder.bind(context, item, pokemonId)

    }

}

class ListedPokemonViewHolder(item: View) : ViewHolder(item) {

    val tvListedPokemonNumber = ItemListedPokemonBinding.bind(item).tvListedPokemonNumber
    val tvListedPokemonName = ItemListedPokemonBinding.bind(item).tvListedPokemonName
    val ivListedPokemonSprite = ItemListedPokemonBinding.bind(item).ivListedPokemonSprite

    @SuppressLint("SetTextI18n")
    fun bind(context: Context, item: ListedPokemonResponse, pokemonId: Int) {

        tvListedPokemonNumber.text = "#${pokemonId}"

        val firstLetter = item.pokemonName[0].uppercase()
        val listedPokemonName = firstLetter + item.pokemonName.substring(1, item.pokemonName.length)

        tvListedPokemonName.text = listedPokemonName

        val spriteUrl = "https://cdn.traction.one/pokedex/pokemon/${pokemonId}.png"
        Glide.with(context).load(spriteUrl).placeholder(R.drawable.pokemon_placeholder).into(ivListedPokemonSprite)
    }

}