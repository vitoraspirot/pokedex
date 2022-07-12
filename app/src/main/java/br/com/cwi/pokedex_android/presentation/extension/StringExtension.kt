package br.com.cwi.pokedex_android.presentation.extension

fun String.firstLetterUpperCase(): String {
    val firstLetter = this[0].uppercase()
    return firstLetter + this.substring(1, this.length)
}