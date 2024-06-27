package machine

import kotlin.system.exitProcess

data class Ingridients(var water: Int, var milk: Int, var coffee: Int, var count: Int)

abstract class Coffee() {
    abstract val water: Int
    abstract val milk: Int
    abstract val coffee: Int
    abstract val money: Int

    fun createCoffee(ingredients: Ingridients, moneyPre: Int): Pair<Ingridients, Int> {
        var (water, milk, coffee, count) = ingredients
        val money = moneyPre + this.money
        water -= this.water
        milk -= this.milk
        coffee -= this.coffee
        count -= 1
        return Pair(Ingridients(water, milk, coffee, count), money)
    }

    fun isEnough(ingredients: Ingridients, money: Int): Pair<Ingridients, Int> {
        val (water, milk, coffee, count) = ingredients
        return when {
            water - this.water < 0 -> {
                println("Sorry, not enough water!\n")
                Pair(ingredients, money)
            }

            milk - this.milk < 0 -> {
                println("Sorry, not enough milk!\n")
                Pair(ingredients, money)
            }

            coffee - this.coffee < 0 -> {
                println("Sorry, not enough coffee!\n")
                Pair(ingredients, money)
            }

            count - 1 < 0 -> {
                println("Sorry, not enough cup!\n")
                Pair(ingredients, money)
            }

            else -> {
                println("I have enough resources, making you a coffee!\n")
                createCoffee(ingredients, money)
            }
        }
    }

    data class espresso(
        override val water: Int = 250,
        override val milk: Int = 0,
        override val coffee: Int = 16,
        override val money: Int = 4
    ) : Coffee()

    data class latte(
        override val water: Int = 350,
        override val milk: Int = 75,
        override val coffee: Int = 20,
        override val money: Int = 7
    ) : Coffee()

    data class cappuccino(
        override val water: Int = 200,
        override val milk: Int = 100,
        override val coffee: Int = 12,
        override val money: Int = 6
    ) : Coffee()
}

class CoffeeMachine() {
    var water = 400
        set(value) {
            field = value
            ingredients.water = value
        }
    var milk = 540
        set(value) {
            field = value
            ingredients.milk = value
        }
    var coffee = 120
        set(value) {
            field = value
            ingredients.coffee = value
        }
    var count = 9
        set(value) {
            field = value
            ingredients.count = value
        }
    var money = 550

    var ingredients = Ingridients(water, milk, coffee, count)
        set(value) {
            field = value
            this.water = value.water
            this.milk = value.milk
            this.coffee = value.coffee
            this.count = value.count
        }

    fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        count += readln().toInt()
        println()
    }

    fun take() {
        println("I gave you $$money\n")
        money = 0
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val operator = readln()

        when (operator) {
            "1" -> {
                val result = Coffee.espresso().isEnough(ingredients, money)
                ingredients = result.first
                money = result.second
            }
            "2" -> {
                val result = Coffee.latte().isEnough(ingredients, money)
                ingredients = result.first
                money = result.second
            }
            "3" -> {
                val result = Coffee.cappuccino().isEnough(ingredients, money)
                ingredients = result.first
                money = result.second
            }

            "back" -> action()

            else -> action()
        }
    }

    fun action() {
        while (true) {
            println("Write action (buy, fill, take, remaining, exit):")
            val operator = readln()
            if (operator != "exit") {
                when (operator) {
                    "fill" -> fill()

                    "take" -> take()

                    "buy" -> buy()

                    "remaining" -> remaining()
                }
            } else exitProcess(1)
        }
    }

    fun remaining() {
        val string = "\nThe coffee machine has:\n" +
                "${this.water} ml of water\n" +
                "${this.milk} ml of milk\n" +
                "${this.coffee} g of coffee beans\n" +
                "${this.count} disposable cups\n" +
                "$${this.money} of money\n"
        println(string)
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.action()
}
