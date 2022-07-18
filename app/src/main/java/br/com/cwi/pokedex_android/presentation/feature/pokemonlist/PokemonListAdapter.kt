package br.com.cwi.pokedex_android.presentation.feature.pokemonlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.presentation.feature.pokemonlist.viewholder.ListedPokemonViewHolder

class PokemonListAdapter(
    val context: Context,
    private val list: List<ListedPokemon>,
    private val onItemClicked: (ListedPokemon) -> Unit
) :
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

        holder.bind(context, item, pokemonId, onItemClicked)

    }

}

