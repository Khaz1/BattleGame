package warrior

/**
 * Интерфейс, описывающий воина
 */
interface Warrior {

    /**
     * Возвращает true, если воин убит
     * и false, если жив
     */
    val isKilled : Boolean

    /**
     * Шанс избежать попадания
     */
    val evasion: Int

    /**
     * Атаковать противника
     *
     * @param enemyWarrior воин-противник
     */
    fun attack(enemyWarrior: AbstractWarrior)

    /**
     * Получить урон
     *
     * @param amount количество полученного урона
     */
    fun takeDamage(amount: Int)
}