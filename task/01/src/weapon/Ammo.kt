package weapon

import kotlin.random.Random

/**
 * Класс, описывающий виды возможных патронов
 *
 * @param damage - урон
 * @param chanceCriticalDamage - шанс критического урона
 * @param coefficientCriticalDamage - коэффициент критического урона
 */
enum class Ammo(
    private val damage: Int,
    private var chanceCriticalDamage: Int,
    private val coefficientCriticalDamage: Int
) {
    STANDART(5, 25, 2),
    ARMORPIERCING(7, 20, 3),
    INCENDIARY(10, 15, 6);

    fun receiveCurrentDamage(): Int {
        return if (chanceCriticalDamage.isCritical()) {
            damage * coefficientCriticalDamage
        } else damage
    }

    /**
     * Возвращает true, если урон критичный
     * В противном случае false.
     */
    private fun Int.isCritical(fullChance: Int = DEF_FULL_CHANCE): Boolean {
        return (Random.nextInt(0, fullChance)) > fullChance - chanceCriticalDamage
    }

    companion object {
        private const val DEF_FULL_CHANCE = 100
    }

}
