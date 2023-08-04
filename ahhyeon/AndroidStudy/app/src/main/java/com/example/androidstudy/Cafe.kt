package com.example.androidstudy

enum class Temperature {
    Hot, Ice
}

enum class CoffeeOption {
    Vanilla, Almond, None
}

abstract class Menu {
    abstract val menuName: String
    abstract val price: Int
    abstract fun getMenu()
}

abstract class Coffee : Menu() {

    protected var optionTemperature: Temperature = Temperature.Hot

    fun setTemperature(temperature: Temperature) {
        optionTemperature = temperature
    }

    override fun getMenu() {
        println("${price}원 ${optionTemperature.name} $menuName 나왔습니다!")
    }
}

class Americano : Coffee(), VanillaCream, AlmondCream {

    override val price = 4000
    override val menuName = "아메리카노"
    private var coffeeOption: CoffeeOption = CoffeeOption.None

    override fun getMenu() {
        println("${price}원 $coffeeOption $optionTemperature $menuName 나왔습니다!")
    }

    override fun setVanillaCream(option: CoffeeOption) {
        coffeeOption = option
    }

    override fun setAlmondCream(option: CoffeeOption) {
        coffeeOption = option
    }
}

interface VanillaCream {
    fun setVanillaCream(option: CoffeeOption)
}

interface AlmondCream {
    fun setAlmondCream(option: CoffeeOption)
}

interface GrapeFruit

class GrapeFruitAde : Menu(), GrapeFruit {
    override val menuName = "자몽에이드"
    override val price: Int = 4500
    override fun getMenu() {
        println("$menuName 나왔습니다!")
    }
}

class GrapeFruitHoneyTea : Menu(), GrapeFruit {
    override val menuName = "자몽에이드"
    override val price: Int = 4500
    override fun getMenu() {
        println()
    }
}