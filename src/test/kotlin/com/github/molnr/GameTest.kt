package com.github.molnr

import com.github.molnr.deck.provider.DeckProviderStrategy
import com.github.molnr.player.Dealer
import com.github.molnr.player.Sam
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class GameTest {

    private fun getDeck(filename: String) =
        DeckProviderStrategy().getDeckProvider(arrayOf(filename)).getDeck()

    @Test
    fun `test random game does not fail`() {
        assertDoesNotThrow { main(emptyArray()) }
    }

    @Test
    fun `test game when both sam and dealer start with blackjack`() {
        val deck = getDeck("both-blackjack")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(sam.name, winner.name)
    }

    @Test
    fun `test game when both sam and dealer bust`() {
        val deck = getDeck("both-bust")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(dealer.name, winner.name)
    }

    @Test
    fun `test game when dealer has blackjack`() {
        val deck = getDeck("dealer-blackjack")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(dealer.name, winner.name)
    }

    @Test
    fun `test game when dealer busts at start`() {
        val deck = getDeck("dealer-busts-at-start")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(sam.name, winner.name)
    }

    @Test
    fun `test game when sam has blackjack`() {
        val deck = getDeck("sam-blackjack")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(sam.name, winner.name)
    }

    @Test
    fun `test game when sam busts at start`() {
        val deck = getDeck("sam-busts-at-start")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(dealer.name, winner.name)
    }

    @Test
    fun `test game when sam stands at start and dealer busts`() {
        val deck = getDeck("sam-stands-at-start-dealer-busts")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(sam.name, winner.name)
    }

    @Test
    fun `test game when sam stands at start and dealer scores higher`() {
        val deck = getDeck("sam-stands-at-start-dealer-scores-higher")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(dealer.name, winner.name)
    }

    @Test
    fun `test game when sam stands during game and dealer busts`() {
        val deck = getDeck("sam-stands-during-game-dealer-busts")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(sam.name, winner.name)
    }

    @Test
    fun `test game when sam stands during game and dealer scores higher`() {
        val deck = getDeck("sam-stands-during-game-dealer-scores-higher")
        val sam = Sam()
        val dealer = Dealer(sam, deck)

        val winner = Game(dealer, sam).play()
        assertEquals(dealer.name, winner.name)
    }

}