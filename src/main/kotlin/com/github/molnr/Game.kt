package com.github.molnr

import com.github.molnr.deck.provider.DeckProviderStrategy
import com.github.molnr.logging.DummyLogger
import com.github.molnr.player.Dealer
import com.github.molnr.player.Player
import com.github.molnr.player.Sam

val logger = DummyLogger(debugEnabled = true)

fun main(args: Array<String>) {
    val deckProvider = DeckProviderStrategy().getDeckProvider(args)
    val deck = deckProvider.getDeck()

    val sam = Sam()
    val dealer = Dealer(sam, deck)

    val game = Game(dealer, sam)
    val winner = game.play()
    game.printResult(winner.name)
}

class Game(
    private val dealer: Dealer,
    private val player: Player
) {

    companion object {
        const val SCORE_LIMIT = 21
        const val HAND_SIZE_AT_START = 2
    }

    fun play(): Player {
        dealer.startGame()
        val winnerAtStart = evaluateGame()
        if (winnerAtStart != null) {
            logger.debug("Winner at start: $winnerAtStart")
            return winnerAtStart
        }

        while (player.isInGame()) {
            dealer.dealToPlayer(player)
        }

        if (!player.isBusted()) {
            while (dealer.isInGame()) {
                dealer.dealToPlayer(dealer)
            }
        }

        return evaluateGame()!! // at this point we have a winner
    }

    private fun evaluateGame(): Player? = when {
        player.isBusted() -> dealer
        player.hasBlackjack() || dealer.isBusted() -> player
        dealer.hasBlackjack() -> dealer

        // the dealer does not stop unless they bust or beat the player, no need to compare hand values here
        !player.isInGame() && !dealer.isInGame() -> dealer

        else -> null
    }

    fun printResult(nameOfWinner: String) {
        logger.info(nameOfWinner)
        player.printHand();
        dealer.printHand();
    }

}