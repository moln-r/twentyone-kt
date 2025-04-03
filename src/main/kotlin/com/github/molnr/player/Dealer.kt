package com.github.molnr.player

import com.github.molnr.Game
import com.github.molnr.deck.Deck

class Dealer(
    private val sam: Sam,
    private val deck: Deck
) : Player(name = "dealer") {

    override fun updateStatus() {
        val valueOfHand = getValueOfHand()
        if (valueOfHand > Game.SCORE_LIMIT) {
            this.status = Status.BUSTED
        } else {
            val opponentValueOfHand = sam.getValueOfHand()
            if (opponentValueOfHand < valueOfHand) {
                this.status = Status.STANDS
            }
        }
    }

    fun dealToPlayer(player: Player) {
        player.addCardToHand(deck.getNextCard())
    }

    fun startGame() {
        // start with the following order: sam, dealer, sam, dealer
        repeat(Game.HAND_SIZE_AT_START) {
            dealToPlayer(sam)
            dealToPlayer(this)
        }
    }

}