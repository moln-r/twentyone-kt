package com.github.molnr.deck

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CardTest {

    @Test
    fun `test invalid suite from string`() {
        assertThrows<IllegalArgumentException> { Card.Suite.fromString("INVALID") }
    }

    @Test
    fun `test invalid rank from string`() {
        assertThrows<IllegalArgumentException> { Card.Rank.fromString("INVALID") }
    }

}