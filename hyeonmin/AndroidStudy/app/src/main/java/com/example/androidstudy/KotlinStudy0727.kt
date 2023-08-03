package com.example.androidstudy

//Git push 하는 법

fun main(){


    // 과제 : 고차함수, 람다함수, 공부하기
    //0727공부한 내용 : nullable한 타입 변수와 연산자 null 타입을 처리하는 연산자에 대해서 공부 코틀린 확장함수 어떻게 만드는지 공부하기
    // data class가 뭔지 어떻게 쓰는지 장점 단점 모든 것 알아오기
    // 함수형 프로그래밍, 객체지향 프로그래밍 개념 공부


    //null 안정성

    printName(null)
    printName("홍길동")

}

//확장함수 , 원래 있었던 함수처럼 확장해서 사용할 수 있음, 재사용 가능
//fun List<Int>.getHigherThan(n : Int) = filter { it>n }
//문자열이 숫자로 변환이 되는 경우에는 변환된 숫자를 반환하고 안되는 문자열이면 null
// 문자열 길이가 n을 초과하면 반환해라 아니면 말아라
//fun String.a(n : String?){
//    n?.let{
//        n.toInt()
//    } ?:{
//        null
//    }
//}

fun String.Check()= this.toIntOrNull()


fun printName(name : String?){
//        if(name !=null){
//            println("$name")
//        }
//        else{
//            println("I don't have name")
//        }

    //null이 아님을 알려줌
    name?.let{
        println("My name is $name")
    } ?:{
        println("I don't have name")
    }
}

