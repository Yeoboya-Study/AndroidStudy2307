package com.example.androidstudy

fun main() {

    val menu = (getMenu(1) as Americano).apply {
        setTemperature(Temperature.Hot)
        setVanillaCream(CoffeeOption.Vanilla)
    }
    menu.getMenu()

    val menu2 = (getMenu(2) as GrapeFruitAde)
    menu2.getMenu()

    val americano = Americano().apply {
        setTemperature(Temperature.Hot)
        setVanillaCream(CoffeeOption.Vanilla)
    }
    americano.getMenu()
    println(americano is VanillaCream)
}

fun getMenu(order: Int): Menu {
    return when (order) {
        1 -> Americano()
        2 -> GrapeFruitAde()
        else -> GrapeFruitHoneyTea()
    }
}
