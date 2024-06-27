Coffee Machine

This project is a simulation of a coffee machine written in Kotlin. It allows users to buy different types of coffee, fill the machine with ingredients, take money from the machine, and check the remaining ingredients and money.
Project Description

The Coffee Machine project is a console-based application that simulates the functionalities of a real coffee machine. It supports the following operations:

    Buy Coffee: Users can choose between espresso, latte, and cappuccino. The machine checks if there are enough ingredients and disposable cups to make the selected coffee.
    Fill Machine: Users can add more water, milk, coffee beans, and disposable cups to the machine.
    Take Money: Users can take all the money accumulated in the machine.
    Remaining Ingredients: Users can check the current state of the machine, including the amount of water, milk, coffee beans, disposable cups, and money.
    Exit: Users can exit the application.

Classes and Methods
Ingridients

A data class that represents the ingredients available in the coffee machine.

kotlin

data class Ingridients(var water: Int, var milk: Int, var coffee: Int, var count: Int)

Coffee

An abstract class that represents a type of coffee. It contains abstract properties for the amount of water, milk, coffee, and money required to make the coffee. It also includes methods to create a coffee and check if there are enough ingredients.

kotlin

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

CoffeeMachine

A class that represents the coffee machine. It includes properties for water, milk, coffee, disposable cups, and money. It also contains methods to perform various actions such as filling the machine, taking money, buying coffee, and checking the remaining ingredients.

kotlin

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

Main Function

The entry point of the application. It creates an instance of the CoffeeMachine class and starts the action loop.

kotlin

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.action()
}
