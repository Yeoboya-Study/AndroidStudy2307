package com.example.androidstudy

class Latte(menuDetail : LatteMenu) : CoffeeMenu {

    //라떼는 기본 Hot 설정
    override lateinit var temperature: CoffeeMenu.Temperature
    override val name: String = menuDetail.naming
    override var price: Int = 4000


    enum class LatteMenu(var naming : String) {
        Cafe("카페 라떼"), Vanilla("바닐라 라떼"), Almond("아몬드 라떼"),
    }
}
