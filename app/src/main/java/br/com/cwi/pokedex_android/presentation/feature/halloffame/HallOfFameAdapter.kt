package br.com.cwi.pokedex_android.presentation.feature.halloffame

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.data.database.entity.PokemonEntity
import br.com.cwi.pokedex_android.data.database.mapper.toListedPokemon
import br.com.cwi.pokedex_android.domain.entity.ListedPokemon
import br.com.cwi.pokedex_android.presentation.feature.pokemonlist.viewholder.ListedPokemonViewHolder

class HallOfFameAdapter(
    val context: Context,
    private val list: List<PokemonEntity>,
    private val onItemClicked: (ListedPokemon) -> Unit
) :
    RecyclerView.Adapter<ListedPokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListedPokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_listed_pokemon, parent, false)
        return ListedPokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListedPokemonViewHolder, position: Int) {
        val item = list[position]

        holder.bind(context, item.toListedPokemon(), item.pokemonId, onItemClicked)
    }

    override fun getItemCount() = list.size


}