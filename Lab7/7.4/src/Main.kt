import kotlin.random.Random

data class Card(val value: Int, val suit: String)

class Deck {
    private val suits = listOf("Черви", "Бубни", "Крестья", "Пики")
    private val values = (1..13).toList()
    private val cards: MutableList<Card> = mutableListOf()

    init {
        for (suit in suits) {
            for (value in values) {
                cards.add(Card(value, suit))
            }
        }
        shuffle()
    }

    private fun shuffle() {
        cards.shuffle()
    }

    fun drawCard(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(cards.size - 1) else null
    }
}

class Player(val name: String) {
    val hand = mutableListOf<Card>()

    fun addCard(card: Card) {
        hand.add(card)
    }

    fun calculateScore(): Int {
        var score = hand.sumOf { if (it.value > 10) 10 else it.value }
        val aces = hand.count { it.value == 1 }


        for (i in 0 until aces) {
            if (score + 10 <= 21) {
                score += 10
            }
        }
        return score
    }

    fun showHand() {
        println("$name рука  ${hand.joinToString(", ") { "${it.value} - ${it.suit}" }} (Счёт: ${calculateScore()})")
    }
}

fun main() {
    val deck = Deck()
    val player = Player("Игрок")
    val dealer = Player("Диллер")


    repeat(2) {
        player.addCard(deck.drawCard()!!)
        dealer.addCard(deck.drawCard()!!)
    }


    while (true) {
        player.showHand()
        println("Взять карту или оставить ? (h/s)")
        when (readLine()) {
            "h" -> {
                player.addCard(deck.drawCard()!!)
                if (player.calculateScore() > 21) {
                    player.showHand()
                    println("Перебор, диллер победил! ")
                    return
                }
            }
            "s" -> break
            else -> println(" направильно, выбери 'h' или 's'.")
        }
    }


    while (dealer.calculateScore() < 17) {
        dealer.addCard(deck.drawCard()!!)
    }


    dealer.showHand()


    val playerScore = player.calculateScore()
    val dealerScore = dealer.calculateScore()

    when {
        dealerScore > 21 -> println("У диллера перебор, ты победил!")
        playerScore > dealerScore -> println("Ты победил!")
        dealerScore > playerScore -> println("Диллер победил!")
        else -> println("Ничья!")
    }
}
