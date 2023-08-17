package com.example.androidstudy.assignment

enum class Temperature {
    Hot, Ice
}

enum class CoffeeOption {
    Vanilla, Almond, Basic
}

enum class Fruit {
    Apple, Grapefruit , Lemon
}

abstract class Menu(var name: String,var price:Int){
    var tempOption: Temperature = Temperature.Ice
    var creamOption: CoffeeOption = CoffeeOption.Basic
    var fruitOption: Fruit = Fruit.Grapefruit

    abstract fun getMenu()

    open fun setTemperature(temp: Temperature){
        tempOption = temp
    }

    open fun setCream(option: CoffeeOption) {
        creamOption = option
    }

    open fun setFruit(fruit:Fruit){
        fruitOption = fruit
    }
}


class Americano: Menu("아메리카노",4000) {
    override fun getMenu() {
        println("${price}원 ${creamOption} ${tempOption} 아메리카노 나왔습니다.")
    }
}

class CafeLatte: Menu("카페라떼",4500) {
    override fun getMenu() {
        println("${price}원 ${tempOption} 카페라떼 나왔습니다.")
    }
}

class VanillaLatte: Menu("바닐라라떼",4700) {
    override fun getMenu() {
        println("${price}원 ${tempOption} 카페라떼 나왔습니다.")
    }
}

class Frappuccino: Menu("프라푸치노",5300) {
    override fun getMenu() {
        println("${price}원 ${creamOption} 프라푸치노 나왔습니다.")
    }
}

class Ade: Menu("에이드",4800) {
    override fun getMenu() {
        println("${price}원 ${fruitOption}에이드 나왔습니다.")
    }
}

class HoneyBlackTea: Menu("허니블랙티",4400) {
    override fun getMenu() {
        println("${price}원 ${fruitOption}허니블랙티 나왔습니다.")
    }
}

fun main(){
    val americano = Americano().apply{
        setTemperature(Temperature.Hot)
        setCream(CoffeeOption.Vanilla)
    }

    val cafeLatte = CafeLatte().apply{
        setTemperature(Temperature.Hot)
    }

    val ade = Ade().apply{
        setFruit(Fruit.Grapefruit)
    }

    val HoneyBlackTea = HoneyBlackTea().apply{
        setFruit(Fruit.Grapefruit)
    }

    americano.getMenu()
    cafeLatte.getMenu()
    ade.getMenu()
    HoneyBlackTea.getMenu()

}