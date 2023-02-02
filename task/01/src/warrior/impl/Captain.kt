import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.FireType
import weapon.Weapons
import kotlin.random.Random

class Captain : AbstractWarrior() {
    override val evasion: Int
        get() = 15
    override var isKilled: Boolean = false
    override val maxHP: Int
        get() = 150
    override val accuracy: Int
        get() = 35
    override val weapon: AbstractWeapon
        get() {
            val weapon = when (Random.nextInt(1,3)) {
                1 -> Weapons.createPistol(FireType.SingleFire)
                2 -> Weapons.createSMG(FireType.BurstShooting(Random.nextInt(1, 7)))
                else ->  Weapons.createRifle(FireType.SingleFire)}
            return weapon
        }
    override var currentHP: Int
        get() = 150
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

//fun main(){
//    val cap = Captain()
//    val weapon: AbstractWeapon = when(Random.nextInt( 1, 3)) {
//        1 -> Weapons.createPistol(FireType.SingleFire)
//        2 -> Weapons.createSMG(FireType.BurstShooting(Random.nextInt(1, 7)))
//        else ->  Weapons.createRifle(FireType.SingleFire)
//    }
//    weapon.reload()
//    weapon.reload()
//    if (weapon.hasBulletsInStore) {
//        println("Всё ок")
//    } else println("Не ок")
//}