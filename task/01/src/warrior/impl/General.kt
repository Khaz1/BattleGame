package warrior.impl

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.FireType
import weapon.Weapons
import kotlin.random.Random

class General : AbstractWarrior() {
    override val evasion: Int
        get() = 30
    override var isKilled: Boolean = false
    override val maxHP: Int
        get() = 250
    override val accuracy: Int
        get() = 50
    override var weapon: AbstractWeapon = Weapons.createPistol(FireType.SingleFire)
        get() {
            return field
        }
        set(value) {
            field = when (Random.nextInt(1, 3)) {
                1 -> Weapons.createPistol(FireType.SingleFire)
                2 -> Weapons.createSMG(FireType.BurstShooting(Random.nextInt(1, 7)))
                else -> Weapons.createRifle(FireType.SingleFire)
            }
        }
    override var currentHP: Int
        get() = 250
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
