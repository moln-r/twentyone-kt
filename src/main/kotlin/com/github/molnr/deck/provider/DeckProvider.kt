package com.github.molnr.deck.provider

import com.github.molnr.deck.Card
import com.github.molnr.deck.Deck
import com.github.molnr.logger
import java.util.*

abstract class DeckProvider {

    open fun getDeck(): Deck {
        val cards = buildDeck()
        validateDeck(cards)
        logger.debug(cards.toString())
        return Deck(cards)
    }

    protected abstract fun buildDeck(): Queue<Card>

    private fun validateDeck(cards: Queue<Card>): Boolean {
        return cards.size == Card.Suite.entries.size * Card.Rank.entries.size && // we want a full deck
                cards.size == cards.toSet().size // we want unique cards
    }

}