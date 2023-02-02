package weapon

/**
 * Класс для вида стрельбы
 */
sealed class FireType {

    /**
     * Одиночная стрельба. 1 выстрел = 1 патрон
     */
    object SingleFire : FireType()

    /**
     * Стрельба очередью
     *
     * @param shootingSize - размер очереди (кол-во патронов, которое должно вылететь при одном выстреле)
     * 1 выстрел = [shootingSize] патронов
     */
    data class BurstShooting(val shootingSize: Int) : FireType()
}
