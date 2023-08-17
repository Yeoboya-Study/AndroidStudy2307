package com.example.androidstudy.chap04

fun main() {
    // 스위치문처럼 break를 사용하지 않아도 된다.
    val x = 9
    when (x) {// 인수 없이도 when문 작성 가능
        // 인자를 받지 않을 때 다양한 변수에 대한 조건구성가능 & 비교연산자 사용가능
        //parseInt(s)->print("일치함")// 함수 반환값
        0,-1 -> print("x==0 or x==1")
        1 -> print("x==1")
        2 -> print("x==2")
        !in 10..20-> print("x는 10~20숫자가 아닙니다")
        is Int-> print("int형입니다")
        else -> { //블록구문 사용가능
            print("조건에 맞지 않음")
        }
    }

}