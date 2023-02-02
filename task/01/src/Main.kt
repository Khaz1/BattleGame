fun main() {
    val firstTeam = Team("Пестики", emptyList())
    val secondTeam = Team("Тычинки", emptyList())
    val battle = Battle(firstTeam, secondTeam)

    //основной игровой цикл
    while (!battle.isBattleOver) {
        battle.makeBattle(2)
        when (val state = battle.getBattleState()) {
            BattleState.DrawState -> state.onDraw(battle)
            BattleState.FirstTeamWon -> state.onTeamWon(battle, firstTeam)
            is BattleState.Progress -> state.onProgress(state.team)
            BattleState.SecondTeamWon -> state.onTeamWon(battle, secondTeam)
            else -> TODO()
        }
    }
}

private fun BattleState.onDraw(battle: Battle) {
    println("Ничья")
    battle.isBattleOver = true
}

private fun BattleState.onTeamWon(battle: Battle, team: Team) {
    println("Команда $team")
    battle.isBattleOver = true
}

private fun BattleState.onProgress(team: Team) {
    println("Игра идет")
}