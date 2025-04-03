package com.github.molnr.deck.provider

import com.github.molnr.exception.NonUniqueDeckException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DeckProviderStrategyTest {

    private fun getDeck(filename: String) =
        DeckProviderStrategy().getDeckProvider(arrayOf(filename)).getDeck()

    @Test
    fun `test invalid filename`() {
        assertThrows<IllegalArgumentException> { getDeck("invalid-filename") }
    }

    @Test
    fun `test non unique deck`() {
        assertThrows<NonUniqueDeckException> { getDeck("non-unique-deck") }
    }

}