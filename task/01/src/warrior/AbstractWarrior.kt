package warrior

import weapon.AbstractWeapon

abstract class AbstractWarrior : Warrior {
    abstract override val evasion: Int

    abstract override var isKilled: Boolean

    //максимальный уровень здоровья
    abstract val maxHP: Int

    //точность - вероятность попадания
    abstract val accuracy: Int

    //оружие
    abstract val weapon: AbstractWeapon
//        get() {
//            val weapon1 = when (Random.nextInt(1,3)) {
//            1 -> Weapons.createPistol(fireType = FireType.SingleFire)
//            2 -> Weapons.createSMG(fireType = FireType.BurstShooting(3))
//            3 -> Weapons.createRifle(fireType = FireType.SingleFire)
//            else -> {
//                TODO()
//            }
//        }
//        return weapon1
//        }

    //текущий уровень здоровья
    abstract var currentHP: Int

    /**
     * Функция
     */


    override fun attack(enemyWarrior: AbstractWarrior) {

    }

    /**
     * Функция
     */

    override fun takeDamage(amount: Int) {
    }
}