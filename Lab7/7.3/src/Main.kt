fun calculatePoints(wins: Int, draws: Int, losses: Int): Int {
    val pointsFromWins = wins * 3
    val pointsFromDraws = draws * 1
    val pointsFromLosses = losses * 0
    return pointsFromWins + pointsFromDraws + pointsFromLosses
}

fun main() {
    val wins = 10
    val draws = 5
    val losses = 3

    val totalPoints = calculatePoints(wins, draws, losses)
    println("Общее количество очков: $totalPoints")
}
