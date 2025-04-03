package com.github.molnr

import com.github.molnr.deck.Card
import com.github.molnr.deck.Deck
import com.github.molnr.deck.provider.DeckProvider
import com.github.molnr.exception.EmptyDeckException
import com.github.molnr.player.Dealer
import com.github.molnr.player.Sam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class InvalidGameTest {

    private class InvalidDeckProvider : DeckProvider() {

        override fun buildDeck(): Queue<Card> {
            val cards = LinkedList<Card>()

            cards.add(Card(Card.Suite.HEARTS, Card.Rank.TEN))
            cards.add(Card(Card.Suite.HEARTS, Card.Rank.NINE))
            cards.add(Card(Card.Suite.CLUBS, Card.Rank.TEN))
            cards.add(Card(Card.Suite.CLUBS, Card.Rank.NINE))

            return cards
        }

        override fun getDeck() = Deck(buildDeck())
    }

    @Test
    fun `test invalid scenario when we run out of cards before the game would end`() {
        val deckProvider = InvalidDeckProvider()
        val deck = deckProvider.getDeck()

        val sam = Sam()
        val dealer = Dealer(sam, deck)
        val game = Game(dealer, sam)

        assertThrows<EmptyDeckException> { game.play() }
    }

}