package weapon

object Weapons {

    fun createPistol(fireType: FireType): AbstractWeapon {
        return object : AbstractWeapon() {
            override val fireType: FireType
                get() = fireType
            override val maxSizeInStore: Int
                get() = 12

        }
    }

    fun createSMG(fireType: FireType): AbstractWeapon {
        return object : AbstractWeapon() {
            override val fireType: FireType
                get() = fireType
            override val maxSizeInStore: Int
                get() = 20
        }
    }

    fun createRifle(fireType: FireType): AbstractWeapon {
        return object : AbstractWeapon() {
            override val fireType: FireType
                get() = fireType
            override val maxSizeInStore: Int
                get() = 15
        }
    }
}

//fun main(){
//    val a = Weapons.createPistol(fireType = FireType.SingleFire)
//    println(a.hasBulletsInStore)
//    println(a.hasBulletsInStore)
//}