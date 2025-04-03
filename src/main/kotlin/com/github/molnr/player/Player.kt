package com.github.molnr.player

import com.github.molnr.Game
import com.github.molnr.deck.Card
import com.github.molnr.logger

abstract class Player(
    val name: String,
) {
    // no valid hand can have more cards than 9 (2+2+2+2 + 3+3+3+3 = 20, the next card will make the player lose)
    private val hand: MutableList<Card> = ArrayList(9)

    protected enum class Status {
        IN_GAME,
        STANDS,
        BUSTED,
    }

    protected var status: Status = Status.IN_GAME

    override fun toString(): String {
        return name
    }

    abstract fun updateStatus()

    private fun printStatus() {
        logger.debug("Player($name) is $status, current hand: $hand, value: ${getValueOfHand()}")
    }

    fun addCardToHand(card: Card) {
        this.hand.add(card)
        updateStatus()
        printStatus()
    }

    fun getValueOfHand(): Int {
        return hand.sumOf { it.getValue() }
    }

    fun isBusted(): Boolean {
        return status == Status.BUSTED
    }

    fun hasBlackjack(): Boolean {
        return hand.size == Game.HAND_SIZE_AT_START &&
                getValueOfHand() == Game.SCORE_LIMIT
    }

    fun isInGame(): Boolean {
        return status == Status.IN_GAME
    }

    fun printHand() {
        logger.info("$name: ${hand.joinToString(separator = ", ", transform = { it.toString() })}")
    }

}