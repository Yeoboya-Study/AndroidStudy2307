package com.example.androidstudy

//fun main() {
//
//    // run with apply, let
//
//    var user1 = User().apply{
//        name = "John"
//    }
//
//    var user2 = User().run {
//        age += 26
//        this
//    }
//
//    println(user2.name)
//
//    fun user3()  = with(User()) {
//        age += 26
//        this
//    }
//    println(user3().name)
//
//        //값을 반환받을 필요가 없는 경우
//    var user4 = user1.let {
//        it.name = "John"
//        it.age = 22
//    }


//
//    var user5 :User? =null
//
//    user5?.let{
//        it.name = "Exist"
//    }.apply{
//        this.name = "not"
//    }

//}

class User{
    var name : String? = null
    var age : Int = 0
}


abstract class Animal {
    abstract var species : String
    abstract fun makeSound()
    fun die() {
        println("X")
    }
}

open class Cat : Animal() {
    override var species = "Cat"
    override fun makeSound() {
        println("Meow")
    }
}
open class Dog(override var species : String =  "Dog") : Animal() {
    override fun makeSound() {
        println("Meong")
    }
}

fun main() {
    Cat().makeSound()
    Dog().makeSound()
    LinearDog(3).getLinearCnt()

    DotCat().patte = "dot"
}

interface Linear{
    var cnt : Int
    fun getLinearCnt(){
        println("Line is $cnt")
    }
}

interface Dot{
    var patte : String
        get() = "Dot"
        set(value) = TODO()

    //인터페이스에서 변수 지정할 때에는 get(), set() 함수 구현
    fun getDotCnt() {
        println("Dot is 5")
    }
}

class LinearDog(override var cnt : Int) : Dog(), Linear
class LinearCat(override var cnt : Int) : Cat(), Linear
class DotDog() : Dog(), Dot
class DotCat() : Cat(), Dot


