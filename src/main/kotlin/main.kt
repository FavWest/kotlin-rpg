fun main() {
    val mainChar = MainChar()
    var choice = ""
    println("Intro goes here")
    println("You've escaped the unkillable giant spider, but now you are trapped in an underground tunnel.")
    println("There are flesh-eating skitterers between you and escape. You will have to fight your way out.")

    while(choice!="y" && choice!="n") {
        println("You see good bashing rock on the tunnel floor.")
        println("You're unarmed. It looks like the best weapon available right now.")
        println("Pick it up? Type y for yes, n for no")
        choice=readLine().toString()
        if(choice=="y"){
            println("With no real weapons available, you pick up a rock and hope for the best.")
            val rock = Weapon("a rock", 2)
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
}

fun printInfo(mainChar: MainChar){
    println("You are a level ${mainChar.level} ${mainChar.type.type}.")
    println("You have ${mainChar.armor} armor.")
    println("You are armed with ${mainChar.weapon.description}.")
    println("Your attack is ${mainChar.attack}.")
    println("Your defense is ${mainChar.defense}.")
}

class MainChar(){
    val type = Goblin()
    var level = 0
    var armor = "no"
    var weapon = Weapon("your fists", 0)
    var attack= 1
        get() = type.attack// + weapon.attack + level.attack
    var defense = 0
        get() = type.defense// + armor.defense + level.defense
}

class Goblin(){
    val type = "goblin"
    val attack = 1;
    val defense = 0;
}

class Weapon(val description: String, val attack: Int){
}