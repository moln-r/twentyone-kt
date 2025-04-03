package com.github.molnr.deck

class Card(
    private val suite: Suite,
    private val rank: Rank
) {

    companion object {
        fun fromString(card: String): Card {
            val suite = Suite.fromString(card.substring(0, 1))
            val rank = Rank.fromString(card.substring(1))
            return Card(suite, rank)
        }
    }

    fun getValue(): Int = rank.value

    override fun toString(): String {
        return suite.id + rank.toString()
    }

    enum class Rank(val value: Int) {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
        ACE(11),
        ;

        companion object {
            fun fromString(value: String): Rank {
                return when (value) {
                    "2" -> TWO
                    "3" -> THREE
                    "4" -> FOUR
                    "5" -> FIVE
                    "6" -> SIX
                    "7" -> SEVEN
                    "8" -> EIGHT
                    "9" -> NINE
                    "10" -> TEN
                    "J" -> JACK
                    "Q" -> QUEEN
                    "K" -> KING
                    "A" -> ACE
                    else -> throw IllegalArgumentException("Invalid value input: $value")
                }
            }
        }

        override fun toString(): String {
            return when (this) {
                JACK -> "J";
                QUEEN -> "Q";
                KING -> "K";
                ACE -> "A";
                else -> value.toString()
            }
        }
    }

    enum class Suite(val id: String) {
        CLUBS("C"),
        DIAMONDS("D"),
        HEARTS("H"),
        SPADES("S"),
        ;

        companion object {
            fun fromString(suite: String): Suite {
                return when (suite) {
                    "C" -> CLUBS
                    "D" -> DIAMONDS
                    "H" -> HEARTS
                    "S" -> SPADES
                    else -> throw IllegalArgumentException("Invalid suite input: $suite")
                }
            }
        }
    }

}
