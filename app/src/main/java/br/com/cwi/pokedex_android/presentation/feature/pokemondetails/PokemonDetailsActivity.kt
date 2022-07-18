@file:Suppress("DEPRECATION")

package br.com.cwi.pokedex_android.presentation.feature.pokemondetails

import android.content.Context
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import br.com.cwi.pokedex_android.R
import br.com.cwi.pokedex_android.databinding.ActivityPokemonDetailsBinding
import br.com.cwi.pokedex_android.domain.entity.PokemonType
import br.com.cwi.pokedex_android.presentation.base.BaseBottomNavigation
import br.com.cwi.pokedex_android.presentation.extension.firstLetterUpperCase
import br.com.cwi.pokedex_android.presentation.extension.visibleOrGone
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityPokemonDetailsBinding
    private val viewModel: PokemonDetailsViewModel by viewModel()
    override val currentTab: Int = R.id.menu_pokemon_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBackButton()
        setUpViewModel()
        setUpOnErrorActions()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bnBottomNavigation

    private fun setUpBackButton() {
        val backButton: AppCompatImageButton = findViewById(binding.viewDetailsActionBar.ibBack.id)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setUpHallOfFameButton(pokemonId: Int) {

        val hallOfFameButton: AppCompatImageButton =
            findViewById(binding.viewDetailsActionBar.ibStar.id)

        val pokemon = viewModel.pokemonDetails.value!!

        hallOfFameButton.setImageDrawable(
            getStar(hallOfFameButton.context, pokemonId)
        )

        hallOfFameButton.setOnClickListener {

            if (viewModel.inHallOfFame(pokemonId)) viewModel.removeFromHallOfFame(pokemon)
            else viewModel.addToHallOfFame(pokemon)

            hallOfFameButton.setImageDrawable(
                getStar(it.context, pokemonId)
            )

        }
    }

    private fun getStar(context: Context, pokemonId: Int) = ContextCompat.getDrawable(
        context,
        if (viewModel.inHallOfFame(pokemonId)) R.drawable.ic_gold_star
        else R.drawable.ic_star
    )

    private fun setUpViewModel() {

        viewModel.pokemonDetails.observe(this@PokemonDetailsActivity) { pokemonDetails ->

            binding.tvPokemonName.text = pokemonDetails.name.firstLetterUpperCase()

            val pokemonId = pokemonDetails.pokemonId.toString()
            binding.tvPokemonId.text = "#$pokemonId"

            val mainType = pokemonDetails.types[0].type.name
            binding.tvTypeName.text = mainType.firstLetterUpperCase()

            Glide.with(this)
                .load(getSpriteUrl(pokemonDetails.pokemonId))
                .placeholder(R.drawable.pokemon_placeholder)
                .into(binding.ivSprite)

            setColors(mainType)
            setUpHallOfFameButton(pokemonDetails.pokemonId)
        }

        viewModel.loading.observe(this@PokemonDetailsActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@PokemonDetailsActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        val pokemonName = intent.getStringExtra("name") ?: "pikachu"
        viewModel.fetchPokemonDetails(pokemonName)
    }

    private fun getSpriteUrl(pokemonId: Int) =
        "https://cdn.traction.one/pokedex/pokemon/${pokemonId}.png"

    private fun setUpOnErrorActions() {
        binding.viewError.buttonError.setOnClickListener {
            setUpViewModel()
        }
    }

    private fun setColors(pokeType: String) {

        when (pokeType) {
            PokemonType.ELECTRIC.type -> setElectricColor()
            PokemonType.FIRE.type -> setFireColor()
            PokemonType.GRASS.type -> setGrassColor()
            PokemonType.WATER.type -> setWaterColor()
            PokemonType.PSYCHIC.type -> setPsychicColor()
            PokemonType.BUG.type -> setBugColor()
            PokemonType.FLYING.type -> setFlyingColor()
            PokemonType.GHOST.type -> setGhostColor()
            PokemonType.NORMAL.type -> setNormalColor()
            PokemonType.ROCK.type -> setRockColor()
            PokemonType.FIGHTING.type -> setFightingColor()
            PokemonType.POISON.type -> setPoisonColor()
            PokemonType.GROUND.type -> setGroundColor()
            PokemonType.ICE.type -> setIceColor()
            PokemonType.DRAGON.type -> setDragonColor()
        }

    }

    private fun setElectricColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.electric_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.electric_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.electric_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.electric_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.electric_type_background
            )
        )
    }

    private fun setFireColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.fire_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.fire_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.fire_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.fire_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.fire_type_background
            )
        )
    }

    private fun setGrassColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.grass_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.grass_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.grass_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.grass_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.grass_type_background
            )
        )
    }

    private fun setWaterColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.water_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.water_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.water_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.water_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.water_type_background
            )
        )
    }

    private fun setPsychicColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.psychic_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.psychic_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.psychic_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.psychic_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.psychic_type_background
            )
        )
    }

    private fun setBugColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.bug_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.bug_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.bug_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.bug_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.bug_type_background
            )
        )
    }

    private fun setFlyingColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.flying_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.flying_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.flying_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.flying_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.flying_type_background
            )
        )
    }

    private fun setGhostColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.ghost_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.ghost_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.ghost_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.ghost_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.ghost_type_background
            )
        )
    }

    private fun setNormalColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.normal_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.normal_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.normal_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.normal_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.normal_type_background
            )
        )
    }

    private fun setRockColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.rock_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.rock_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.rock_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.rock_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.rock_type_background
            )
        )
    }

    private fun setFightingColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.fighting_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.fighting_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.fighting_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.fighting_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.fighting_type_background
            )
        )
    }

    private fun setPoisonColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.poison_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.poison_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.poison_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.poison_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.poison_type_background
            )
        )
    }

    private fun setGroundColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.ground_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.ground_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.ground_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.ground_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.ground_type_background
            )
        )
    }

    private fun setIceColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.ice_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.ice_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.ice_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.ice_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.ice_type_background
            )
        )
    }

    private fun setDragonColor() {
        binding.clBackground.setBackgroundColor(
            resources.getColor(R.color.dragon_type_background)
        )
        binding.cvTypeTag.setCardBackgroundColor(
            resources.getColor(R.color.dragon_type_tag)
        )
        binding.viewDetailsActionBar.tbDetailsToolbar.setBackgroundColor(
            resources.getColor(
                R.color.dragon_type_background
            )
        )
        binding.viewDetailsActionBar.ibStar.setBackgroundColor(
            resources.getColor(
                R.color.dragon_type_background
            )
        )
        binding.viewDetailsActionBar.ibBack.setBackgroundColor(
            resources.getColor(
                R.color.dragon_type_background
            )
        )
    }

}