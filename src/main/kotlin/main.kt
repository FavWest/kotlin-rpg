fun main() {
    println("Intro goes here")
    println("You've escaped the unkillable giant spider, but now you are trapped in an underground tunnel.")
    println("There are flesh-eating skitterers between you and escape. You will have to fight your way out.")
    println("With no real weapons available, you pick up a rock and hope for the best.")
    val mainChar = MainChar()
    var choice = ""
    while(choice!="north") {
        println("Type 'north' to advance to the next section of tunnel. Type 'info' to see information about your character")
        choice = readLine().toString()
        if (choice == "north") {
            println("You creep forward, hoping to avoid attention, but a skitter spots you!")
            println("It scrambles toward you, mandibles clicking! Begin combat")
        } else if (choice == "info") {
            printInfo(mainChar)
        }
    }
    choice=""
}

fun printInfo(mainChar: MainChar){
    println("You are a level ${mainChar.level} ${mainChar.type.type}.")
    println("You have ${mainChar.armor} armor.")
    println("You are armed with ${mainChar.weapon}.")
    println("Your attack is ${mainChar.attack}.")
    println("Your defense is ${mainChar.defense}")
}

class MainChar(){
    val type = Goblin()
    var level = 0
    var armor = "no"
    var weapon = "a rock"
    var attack= 0
        get() = type.attack// + weapon.attack + level.attack
    var defense = 0
        get() = type.defense// + armor.defense + level.defense
}

class Goblin(){
    val type = "goblin"
    val attack = 1;
    val defense = 0;
}