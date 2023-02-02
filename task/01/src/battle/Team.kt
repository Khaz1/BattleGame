import warrior.AbstractWarrior
import warrior.impl.General
import warrior.impl.Solder
import kotlin.random.Random

class Team(
    private val name: String,
    private val warriors: List<AbstractWarrior>,
) {

    override fun toString(): String {
        return name
    }

    fun getWarriors(): List<AbstractWarrior> {
        val warriors = warriors.toMutableList()
        val chanceToGetGeneral = 10
        val chanceToGetCaptain = 50
        for (i in 1..2) {
            when (Random.nextInt(0, 100)) {
                in 0..chanceToGetGeneral -> warriors.add(General())
                in chanceToGetGeneral..chanceToGetCaptain -> warriors.add(Captain())
                else -> warriors.add(Solder())
            }
        }
        return warriors
    }

    fun isAlive(): Boolean {
        return warriors.isNotEmpty()
    }
}