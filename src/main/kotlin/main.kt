fun main() {
    val mainChar = Goblin(0)
    var choice = ""
    println("Intro goes here")
    println("You've escaped the unkillable giant spider, but now you are trapped in an underground tunnel.")
    println("There are flesh-eating centipedes called skitterers between you and escape. You will have to fight your way out.")

    while(choice!="y" && choice!="n") {
        println("You see a good bashing rock on the tunnel floor.")
        println("You're unarmed. It looks like the best weapon available right now.")
        println("Pick it up? Type y for yes, n for no")
        choice=readLine().toString()
        if(choice=="y"){
            println("With no real weapons available, you pick up a rock and hope for the best.")
            val rock = Weapon("rock", 2)
            mainChar.weapon = rock
        } else if(choice=="n"){
            println("You decide not to pick up the rock.")
        }
    }
    choice=""

    while(choice!="north") {
        println("Type 'north' to advance to the next section of tunnel. Type 'info' to see information about your character")
        choice = readLine().toString()
        if (choice == "north") {
            println("You creep forward, hoping to avoid attention, but a skitterer spots you!")
            println("It scrambles toward you, mandibles clicking! Begin combat")
        } else if (choice == "info") {
            printInfo(mainChar)
        }
    }
    choice=""
    val skitterer = Skitterer(0)
    combat(mainChar, skitterer)
}

fun printInfo(mainChar: Creature){
    println("You are a level ${mainChar.level} ${mainChar.type}.")
    println("You have ${mainChar.armor.description} armor.")
    println("You are armed with your ${mainChar.weapon.description}.")
    println("Your attack is ${mainChar.attack}.")
    println("Your defense is ${mainChar.defense}.")
}

fun combat(mainChar: Creature, opponent: Creature){
    var choice = ""
    while(mainChar.hp>0 && opponent.hp>0) {
        if (opponent.attack > mainChar.defense) {
            mainChar.hp -= opponent.attack
            println("")
            println("The ${opponent.type} attacks with ${opponent.weapon.description}")
            println("You take ${opponent.attack} damage and have ${mainChar.hp} hit points left")
            println("")
        } else {
            println("You successfully defended yourself again the ${opponent.type}'s attack!")
        }
        println("What would you like to do? (type 'attack' to attack)")
        choice = readLine().toString()
        if (choice == "attack")
            if (mainChar.attack > opponent.defense) {
                opponent.hp -= mainChar.attack
                println("")
                println("You attack with ${mainChar.weapon.description}")
                println("You deal ${mainChar.attack} damage")
                println("")
            } else {
                println("Your attack was ineffective")
            }
    }
    if(mainChar.hp==0){
        println("You died")
    } else {
        println("You defeated the ${opponent.type}!")
    }
}

open class Creature(var level: Int){
    open val type = "any"
    open var baseAttack = 0
    open var baseDefense = 0
    open var armor = Armor("no", 0)
    open var weapon = Weapon("unarmed attack", 0)
    open var hp = 10
    var attack= 1
        get() = baseAttack + weapon.attack + level
    var defense = 0
        get() = baseDefense + armor.defense + level
}

class Goblin(level: Int) : Creature(level){
    override val type = "goblin"
    override var baseAttack = 1
    override var armor = Armor("no", 0)
    override var weapon = Weapon("fists", 0) //TODO generalize
}

class Skitterer(level: Int) : Creature(level){
    override val type = "skitterer"
    override var armor = Armor("chitinous exoskeleton", 2)
    override var weapon = Weapon("bite", 1)
    override var hp = 1
}

class Weapon(val description: String, val attack: Int){
}

class Armor(val description: String, val defense: Int){}