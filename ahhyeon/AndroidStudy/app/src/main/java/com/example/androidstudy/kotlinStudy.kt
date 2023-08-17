package com.example.androidstudy

fun main() {

    val menuList = mutableListOf<Menu>()

    val americano1 = Americano().apply {
        setTemperature(Temperature.Hot)
        addVanilla(CoffeeOption.Vanilla)
    }
    menuList.add(americano1)
    menuList.add(GrapeFruitAde())

    menuList.forEach {
        it.getMenu()
    }

    menuList.filter {
        it is GrapeFruit
    }

    val menuList2 = mutableListOf<MenuData>()

    val americano = MenuData.CoffeeData(
        "americano",
        4000,
        Temperature.Hot,
        CoffeeOption.None
    )

    val iceAmericano = americano.copy(
        temperature = Temperature.Ice
    )

    val latte = MenuData.CoffeeData(
        "latte",
        4500,
        Temperature.Hot,
        CoffeeOption.None
    )

    val grapeFruitAde = MenuData.Beverage(
        name = "grapeFruitAde",
        price = 5000
    )

    val grapeFruitBlackTea = MenuData.Beverage(
        name = "grapeFruitBlackTea",
        price = 5500
    )

    menuList2.addAll(listOf(americano, latte))
    menuList2.add(grapeFruitAde)
    menuList2.add(iceAmericano)

    var nameTextView = ""
    var priceTextView = 0

    menuList2.forEach {
        nameTextView = it.name
        priceTextView = it.price
    }
}

