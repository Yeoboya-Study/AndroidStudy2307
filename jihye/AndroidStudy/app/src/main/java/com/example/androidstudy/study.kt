package com.example.androidstudy

fun main() {
    var number: Int? = 0
    var name: String? = null

    fun introduce(name: String?) {
        name?.let {
            println("안녕하세요 ${name}입니다.")
        } ?: {
            println("이름을 다시 입력해주세요.")
        }
    }

    // 문자열이 숫자로 변환 >  숫자아닌경우 >  null반환하는 확장함수
    fun String.strToInt() {
        this.toIntOrNull()
    }

    // 문자열의 길이가 n을 초과 한쪽만 반환
    fun List<String>.test() {

    }

    class User() {
        var name: String = ""
        var age: Int = 0;
    }

    var user1 = User().apply {
        name = "John"
        age = 25
    }

    var user2 = User().run {
        this.name = "John"
        this.age = 25

    }


    var user3 = with(User()) {
        name = "John"
        age = 25
    }

    var user4 = User().let {
        it.name = "John"
        it.age = 25
        it
    }


}

abstract class Animal {
    abstract val specise: String
    abstract fun makesound()
}

open class Dog : Animal() {
    override val specise = "Dog"
    override fun makesound() {
        println("멍멍")
    }
}

open class Cat : Animal() {
    override val specise = "Cat"
    override fun makesound() {
        println("야옹")
    }
}
interface Dot{
    fun getDotCnt(){
        println("점박이는 점이3개")
    }
}

interface Linear{
    val pattern: String get() = "줄무늬"
    fun getLinearCnt()

}

class LinearCat : Cat(), Linear{
    override fun getLinearCnt() {
        println("줄무늬가 5개")
    }
}



