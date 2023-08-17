package com.example.androidstudy.chap07

// object를 사용한 생성
// 추상클래스로부터 하위클래스를 생성안하고 단일 인스턴스로 객체생성가능
// 임시적 사용시 유용하다

abstract class Printer{
    abstract fun print()//추상메서드
}

val myPrinter = object: Printer(){//객체인스턴스
    override fun print() {// 추상메서드 구현
        println("출력합니다.")
    }

}
fun main() {
    myPrinter.print()
}