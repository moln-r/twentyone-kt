package com.github.molnr.deck

import com.github.molnr.exception.EmptyDeckException
import java.util.*

class Deck(private val cards: Queue<Card>) {

    fun getNextCard(): Card {
        return cards.poll() ?: throw EmptyDeckException()
    }

}