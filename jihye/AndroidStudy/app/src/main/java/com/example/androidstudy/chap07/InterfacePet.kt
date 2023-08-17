package com.example.androidstudy.chap07

// 인터페이스는 현실세계의 계약서와 비슷하다
// 무엇을하라는 추상적인 활동이 적혀있고 인터페이스를 상속받게되면?
//      계약서에 있는 활동에 구체적인 내용을 반드시 실행해야 한다
// 계약서 자체로는 실행될 수 없다

// 추상클래스와 달리 다중상속이 가능하고 강한연관을 가지지않는다.

interface Pet{
    var category:String // abstract 키워드가 없어도 추상프로퍼티

    // 인터페이스에서는 프로퍼티에 값을 저장할 수 없지만 val로 선언된 프로퍼티는
    //      게터를 통해 필요한 내용을 구현할 수 있다
    val msgTags: String
        get() = "I'm your lovely pet!"

    fun feeding() // 마찬가지로 추상메서드
    fun patting(){// 구현부가 존재하면 일반메서드
        println("Keep patting!")
    }
}

class Cat(override var category: String):Pet{
    override fun feeding(){
        println("Feed the cat a tuna can!")
    }
}

fun main(){
    val obj = Cat("small")
    println("Pet Category:${obj.category}")
    println("msgTags:${obj.msgTags}")
    obj.feeding()
    obj.patting()
}