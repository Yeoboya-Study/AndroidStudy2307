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
}

