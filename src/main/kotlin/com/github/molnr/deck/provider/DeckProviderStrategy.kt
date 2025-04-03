package com.github.molnr.deck.provider

import com.github.molnr.deck.Card
import com.github.molnr.exception.NonUniqueDeckException
import java.util.*

class DeckProviderStrategy {

    fun getDeckProvider(args: Array<String>?): DeckProvider {
        if (args.isNullOrEmpty()) {
            return RandomDeckProvider()
        }
        return FileDeckProvider(args.first())
    }

    private class FileDeckProvider(private val filename: String) : DeckProvider() {
        override fun buildDeck(): Queue<Card> {
            val fileContent = {}.javaClass.getResource("/input/$filename")?.readText()
                ?: throw IllegalArgumentException("File not found under /resources/input: $filename")

            val cards = LinkedList<Card>()
            val addedCards = mutableSetOf<String>()

            fileContent.split(",")
                .map { it.trim() }
                .forEach { cardString ->
                    if (addedCards.contains(cardString)) {
                        throw NonUniqueDeckException("Duplicate card found: $cardString")
                    }
                    cards.add(Card.fromString(cardString))
                    addedCards.add(cardString)
                }

            return cards
        }
    }

    private class RandomDeckProvider : DeckProvider() {
        override fun buildDeck(): Queue<Card> =
            LinkedList(Card.Suite.entries.flatMap { suite ->
                Card.Rank.entries.map { value -> Card(suite, value) }
            }.shuffled())
    }

}