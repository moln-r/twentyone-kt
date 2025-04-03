package com.github.molnr.player

import com.github.molnr.Game

class Sam(private val limit: Int = 17) : Player(name = "sam") {

    override fun updateStatus() {
        val valueOfHand = getValueOfHand()
        if (valueOfHand > Game.SCORE_LIMIT) {
            this.status = Status.BUSTED
        } else if (valueOfHand >= this.limit) {
            this.status = Status.STANDS
        }
    }

}