package com.example.androidstudy

sealed class MenuData {

    abstract val name: String
    abstract val price: Int

    data class CoffeeData(
        override val name: String,
        override val price: Int,
        val temperature: Temperature,
        val option: CoffeeOption
    ): MenuData()

    data class Beverage(
        override val name: String,
        override val price: Int
    ): MenuData()
}
