package com.example.androidstudy.chap07

// 추상클래스
// 구현 클래스에서 가져야할 명세를 정의한 클래스 == 프로퍼티 및 메서드의 템플릿이다
// open키워드를 사용하지 않고도 파생클래스 작성이 가능하다
// 인스턴스 생성불가

// 주생성자에 정의된 프로퍼티는 비추상(일반) 프로퍼티
abstract class Vehicle(val name:String, val color:String, val weight:Double){
    // 추상프로퍼티 - 하위클래스에서 반드시 오버라이드(재정의)해야함
    abstract val maxSpeed:Double

    // 일반(비추상) 프로퍼티 : 초기값인 상태를 저장가능
    var year: String ="2000"

    // 추상메서드
    abstract fun start()
    abstract fun stop()

    // 일반(비추상)메서드
    fun displaySpec(){
        //비추상 메서드는 {}의 블록구분처럼 기본적인 구현이 필요함
        println("name: $name, color:$color, weight:$year,maxSpeed:$maxSpeed")
    }
}

// alt+enter : 코드 어시스트
class Car(name: String,
          color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight){
    override fun start() {
        println("Car 출발")
    }

    override fun stop() {
        println("Car 중지")
    }

    fun autoModeOn(){
        println("Auto mode")
    }
}

class Motorbike(name: String,
          color: String,
          weight: Double,
          override val maxSpeed: Double) : Vehicle(name, color, weight){
    override fun start() {
        println("Motorbike 출발")
    }

    override fun stop() {
        println("Motorbike 중지")
    }

}

fun main(){
    var car = Car("Matiz","red",1000.0,100.0)
    var motor = Car("motor1","blue",1000.0,100.0)
    car.year = "2014"
    car.displaySpec()
    motor.displaySpec()
    car.start()
    motor.start()

}