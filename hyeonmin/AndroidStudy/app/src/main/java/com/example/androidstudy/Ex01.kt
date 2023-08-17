package com.example.androidstudy

fun main(){
    val americano = Americano().apply {
        setTemperature(Temperature.Hot)
        setVanilliaCream(CoffeeOption.Vanilla)
    }

    val latte = Latte().apply {
        setTemperature(Temperature.Ice)
        setVanilliaCream(CoffeeOption.None)
    }

    val vanillalatte = VanillaLatte().apply {
        setTemperature(Temperature.Ice)
        setVanilliaCream(CoffeeOption.None)
        this
    }

//    val vanillaCreamF = VanillaCreamF()
//
//    val jamongade = JamongAde()
//
//    val honeyblack = JamongHoneyB()

    americano.getMenu() // 4000원 Vanilla Hot 아메리카노 나왔습니다!
    latte.getMenu()
    vanillalatte.getMenu()

    JamongAde().getMenu()
    VanillaCreamF().getMenu()
    JamongHoneyB().getMenu()

}

interface Menu {
    var price : Int
    val name : String

    fun getMenu()
}

enum class Temperature{
    Hot , Ice
}

enum class CoffeeOption{
    Vanilla, Almond, None
}

abstract class Coffee : Menu{


    open var tem : Temperature? = Temperature.Hot
    open var option : CoffeeOption? = CoffeeOption.Vanilla

    fun setTemperature(tem : Temperature) {
        this.tem = tem
    }

    fun setVanilliaCream(option : CoffeeOption){
        this.option = option
    }

    override fun getMenu(){
        println("${price}원 ${option} ${tem} ${name} 나왔습니다.")
    }


}

abstract class Tea : Menu{


    override fun getMenu() {
        println("${price}원 ${name}나왔습니다.")
    }
}


abstract class Ade : Menu{
    override fun getMenu() {
        println("${price}원 ${name}나왔습니다.")
    }
}




class Americano() : Coffee() {
    override var price: Int = 4000
    override val name : String = "아메리카노"

}

class Latte() : Coffee(){
    override val name : String = "카페 라뗴"
    override var price : Int = 4000
    override var tem : Temperature? = null

    override fun getMenu() {
        println("${price}원 ${option} ${tem} ${name} 나왔습니다.")

    }
}


class VanillaLatte() : Coffee(){
    override val name : String = "바닐라 라떼"
    override var price : Int = 4000

    override fun getMenu() {
        println("${price}원 ${option} ${tem} ${name} 나왔습니다.")
    }

}

class VanillaCreamF() : Coffee(){
    override val name : String = "바닐라 크림 프라푸치노"
    override var price : Int =  4000

    override fun getMenu() {
        println("${price}원 ${name} 나왔습니다.")
    }
}

class JamongAde() : Ade(){
    override val name: String = "자몽 에이드"
    override var price: Int = 4000
}

class JamongHoneyB() : Tea(){
    override val name : String = "자몽 허니 블랙티"
    override var price : Int = 4000
}





















