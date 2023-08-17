package com.example.androidstudy

abstract class Aide : Menu {
    override fun getMenu() {
        println(" 주문한 $name 나왔습니다. 가격은 ${price}입니다 ")
    }
}