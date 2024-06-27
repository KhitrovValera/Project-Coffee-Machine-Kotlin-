# Coffee Machine

This is a console-based implementation of a coffee machine written in Kotlin. The program allows users to buy different types of coffee, fill the machine with ingredients, take money from the machine, and check the remaining ingredients and money.
Requirements

To compile and run this code, you need to have a Kotlin compiler installed on your system. Nothing else is required!

## How to Use

The program prompts the user to choose from several actions: buy coffee, fill the machine, take money, or check the remaining resources. Actions are performed using text input.
## Available Commands

    buy: Buy coffee (espresso, latte, or cappuccino).
    fill: Fill the machine with ingredients.
    take: Take all the money from the machine.
    remaining: Check the remaining ingredients and money.
    exit: Exit the program.

### Buying Coffee

    Choose 1 for espresso.
    Choose 2 for latte.
    Choose 3 for cappuccino.
    Choose back to return to the main menu.

### Filling the Machine

    Enter the amount of water (in milliliters) you want to add.
    Enter the amount of milk (in milliliters) you want to add.
    Enter the amount of coffee beans (in grams) you want to add.
    Enter the number of disposable cups you want to add.

### Taking Money

    The take command allows you to take all the money from the coffee machine.

### Checking Remaining Resources

    The remaining command displays the current state of the coffee machine: the amount of water, milk, coffee beans, disposable cups, and money.

## Implementation Details
### Ingridients Class

    Represents the ingredients available in the coffee machine.


data class Ingridients(var water: Int, var milk: Int, var coffee: Int, var count: Int)

### Abstract Coffee Class

    Represents a type of coffee and the necessary ingredients and cost to make it.
    Methods: createCoffee, isEnough.

abstract class Coffee {
    abstract val water: Int
    abstract val milk: Int
    abstract val coffee: Int
    abstract val money: Int

    fun createCoffee(ingredients: Ingridients, moneyPre: Int): Pair<Ingridients, Int>
    fun isEnough(ingredients: Ingridients, money: Int): Pair<Ingridients, Int>

    data class espresso(...) : Coffee()
    data class latte(...) : Coffee()
    data class cappuccino(...) : Coffee()
}

### CoffeeMachine Class

    Manages the state of the coffee machine and performs actions based on user input.
    Methods: fill, take, buy, action, remaining.

class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffee = 120
    var count = 9
    var money = 550

    var ingredients = Ingridients(water, milk, coffee, count)

    fun fill()
    fun take()
    fun buy()
    fun action()
    fun remaining()
}

### Main Function

    The entry point of the program. Creates an instance of the CoffeeMachine class and starts the main action loop.


fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.action()
}

## Acknowledgments

This console-based implementation of a coffee machine was created for practicing Kotlin programming and simulates the basic functions of a real coffee machine.

Enjoy using the program!
