package com.example.androidstudy

fun main() {

    var aa = Americano().apply {
        temperature = CoffeeMenu.Temperature.Hot
        option = Americano.Option.Vanilla
    }

    aa.getMenu()

    var bb = BlackTea()

    bb.getMenu()
}


