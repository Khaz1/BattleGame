package utils

class MyStack<T> {
    private val elements = mutableListOf<T>()

    fun pop(): T {
        val lastEl = elements.last()
        elements.remove(lastEl)
        return lastEl
    }

    fun push(e: T) {
        elements.add(e)
    }

    fun isEmpty() : Boolean {
        return elements.isEmpty()
    }
}

//fun main(){
//    val stack = MyStack<Ammo>()
//    val pistol = Weapons.createPistol(FireType.SingleFire)
//    pistol.reload()
//    println(pistol.bulletStore)
//    println(pistol.hasBulletsInStore)
//}

/* Example:

fun main() {
    val stack = MyStack<Int>()
    stack.push(3)
    println(stack.pop ())
    stack.pop()
}
*/
