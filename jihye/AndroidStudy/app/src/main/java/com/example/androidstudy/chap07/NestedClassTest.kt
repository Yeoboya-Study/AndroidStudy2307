package com.example.androidstudy.chap07

/*
중첩클래스(Nested class)
기본적으로 정적클래스처럼 다뤄진다
*/

class  Outer{
    val ov = 6
    class Nested{
        val nv=10
        fun greeting()="[Nested]Hello! $nv" //외부 ov에 접근불가
    }
    fun outside(){
        val msg = Nested().greeting()
    }
}