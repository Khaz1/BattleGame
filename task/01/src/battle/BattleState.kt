/**
 * Класс, описывающий текущее состояние сражения
 */
sealed class BattleState {

    /**
     * Прогресс
     *
     * @param team играющая в данный момент команда
     */
    data class Progress(val team: Team) : BattleState()


    /**
     * Победа первой команды
     */
    object FirstTeamWon : BattleState()

    /**
     * Победа второй команды
     */
    object SecondTeamWon : BattleState()

    /**
     * Ничья
     */
    object DrawState : BattleState()
}
