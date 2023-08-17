package com.example.androidstudy

abstract class Tea : Menu {
    override var price : Int = 4500
    abstract override val name : String
    override fun getMenu() {
        println("주문한 $name 나왔습니다. 가격은 $price 입니다.")
    }

    enum class TeaMenu {
        Lemon, Herb, Black
    }

    fun setName(menu : TeaMenu) : String {
       return when(menu){
            TeaMenu.Lemon -> "레몬티"
            TeaMenu.Herb -> "허브티"
            TeaMenu.Black -> "블랙티"
        }
    }
}

class LemonTea : Tea(){
    override val name: String = setName(TeaMenu.Lemon)
}

class HerbTea : Tea(){
    override val name: String = setName(TeaMenu.Herb)
}

class BlackTea : Tea(){
    override val name : String = setName(TeaMenu.Black)
}