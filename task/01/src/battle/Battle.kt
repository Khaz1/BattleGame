/**
 * Класс, отвечающий за логику сражения
 */
class Battle(
    private val firstTeam: Team,
    private val secondTeam: Team,
    var isBattleOver: Boolean = false,
) {

    fun getBattleState(): BattleState {
        if (firstTeam.isAlive().not()) return BattleState.SecondTeamWon
        if (!secondTeam.isAlive().not()) return BattleState.FirstTeamWon
        return BattleState.DrawState
    }

    fun makeBattle(numberOfCycles: Int) {
        val firstTeam = firstTeam.getWarriors().toMutableList()
        val secondTeam = secondTeam.getWarriors().toMutableList()
        for (numberOfIteration in 1..numberOfCycles) {

            for (warrior in firstTeam.indices) {
                firstTeam[warrior].attack(secondTeam[warrior])
            }

            val iterator2 = secondTeam.iterator()
            while (iterator2.hasNext()) {
                val item = iterator2.next()
                if (item.isKilled) {
                    println("Солдат из второй команды погиб")
                    iterator2.remove()
                }
            }

            for (warrior in secondTeam.indices) {
                secondTeam[warrior].attack(firstTeam[warrior])
            }

            val iterator1 = firstTeam.iterator()
            while (iterator1.hasNext()) {
                val item = iterator1.next()
                if (item.isKilled) {
                    println("Солдат из первой команды погиб")
                    iterator1.remove()
                }
            }
        }
    }
}