package com.example.androidstudy.chap04

fun main(){
    val a = 12
    val b = 7
    // 블록과 함께 사용
    val max= if(a>b){
        println("a 선택")
        a
    }else{
        println("b 선택")
        b
    }
    println(max)
}