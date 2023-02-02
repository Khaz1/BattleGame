package weapon

import utils.MyStack
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

abstract class AbstractWeapon {
    /**
     * Тип стрельбы
     */
    abstract val fireType: FireType

    /**
     * Максимальная вместительность магазина
     */
    abstract val maxSizeInStore: Int

    /**
     * Магазин патронов
     */
    open val bulletStore: MyStack<Ammo> = MyStack<Ammo>()


    open val hasBulletsInStore : Boolean
        get() = !bulletStore.isEmpty()

    /**
     * Создание патрона необходимого типа
     */

    open fun createAmmo(): Ammo {
        val ammo: Ammo = when (Random.nextInt(1, 4)) {
            1 -> Ammo.STANDART
            2 -> Ammo.ARMORPIERCING
            3 -> Ammo.INCENDIARY
            else -> {
                TODO()
            }
        }
        return ammo
    }

    /**
     * Перезарядка
     */
    open fun reload(): MyStack<Ammo> {
        for (i in 1..maxSizeInStore) {
           bulletStore.push(createAmmo())
        }
        return bulletStore
    }
    /**
     * Патроны для выстрела, при этом уменьшается количество патронов в магазине
     */
    open fun getBullets(): List<Ammo> {
        val bullets = mutableListOf<Ammo>()
        when (fireType) {
            is FireType.SingleFire -> {
                if (bulletStore.isEmpty()) {
                    reload()
                }
                else bullets.add(bulletStore.pop())
            }
            is FireType.BurstShooting -> {
                for (i in 0..(fireType as FireType.BurstShooting).shootingSize) {
                    if (bulletStore.isEmpty()) {
                        reload()
                    }
                    else bullets.add(bulletStore.pop())
                }
            }
            else -> {}
        }
        return bullets
    }
}

//fun main() {
//    val pistol = Weapons.createPistol(FireType.SingleFire)
//    pistol.reload()
//    println(pistol.hasBulletsInStore)
//}
