package warrior.impl

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.FireType
import weapon.Weapons
import kotlin.random.Random

class Solder : AbstractWarrior() {
    override val evasion: Int
        get() = 10
    override var isKilled: Boolean = false
        get() = false
    override val maxHP: Int
        get() = 100
    override val accuracy: Int
        get() = 25
    override val weapon: AbstractWeapon
        get() {
            return Weapons.createPistol(FireType.SingleFire)
//                when (Random.nextInt(1,3)) {
//            1 -> Weapons.createPistol(FireType.SingleFire)
//            2 -> Weapons.createSMG(FireType.BurstShooting(Random.nextInt(1, 7)))
//                else ->  Weapons.createRifle(FireType.SingleFire)}
//            return weapon
//            }
        }
    override var currentHP: Int
        get() = 100
        set(value) {}

    override fun attack(enemyWarrior: AbstractWarrior) {
        if (weapon.hasBulletsInStore) {
            weapon.getBullets().forEach { bullet ->
                enemyWarrior.takeDamage(bullet.receiveCurrentDamage())
            }
        } else {
            weapon.reload()
        }
    }

    override fun takeDamage(amount: Int) {
        val chanceOfBeingHit : Boolean = Random.nextInt(0,100) < accuracy
        val chanceToTakeDamage: Boolean = Random.nextInt(0, 100) < evasion
        if (chanceToTakeDamage and chanceOfBeingHit) {
            if (currentHP - amount > 0)
                currentHP -= amount
            else {
                currentHP = 0
                isKilled = true
            }
        } else currentHP
    }
}