package com.example.androidstudy

fun main(){
    //가장 효율적으로 값을 할당하는 함수를 찾아라
//    with와 run은 객체에서 직접 작동하도록 설계된 확장 함수
//     also는 부 작용에 사용되며 it을 개체에 대한 참조로 사용
//    val user1 = User().apply {
//        name = "John"
//        age = 28
//
//        //바로 반환할 떄
//    }
//
//    val user2 = User().run {
//        name="John"
//        age = 30
//        this
//    }
//    val test = null
//    test ?: run{
//
//    }
//
//    val user3 = User().also {
//        it.name = "aa"
//        it.age = 11
//
//    }
//
//
//    val user4 = with(User()){
//        name="aaa"
//        age = 35
//        this
//        //
//    }
//    val user6 = User().let{
//        it.name = "jona"
//        it.age=1
//        it
//
//        //바로 반환받지 않고 사용할 떄
//    }
//
//    println("apply ${user1.name} ${user1.age}")
//    println("run ${user2.name} ${user2.age}")
//    println("also ${user3.name} ${user3.age}")
//    println("also ${user4.name} ${user4.age}")
//    println("Name: ${user6.name}, Age: ${user6.age}")

    //

    val a = Dog("개")
    println(a.specices)
    println("개는 ")
    val b = Cat("고양이")
//    println("${b.specices}는 ${b.} ")
    val c = LinearCat("고양이")
    println("${c.specices}")
    println(c.getlinearcnt(""))


}

interface Dott{
    fun getdotcnt(){
        println("점박이는 점이 3개")
    }
}

interface Linear{
    //인터페이스 안에서 변수를 가질 수 있게 하려면 get과 set을 해줘야한다.
    val pattern : String
        get() = "linear"

    fun getlinearcnt(pattern: String)
}

class User{
    var name : String = ""
    var age : Int = 0
}

abstract class Animal{
    abstract val specices :String
    abstract fun makeSound()

}

open class Dog(override val specices: String) : Animal(), Dott{
    override fun makeSound() {
        println("${specices}")
    }

}

open class Cat(override val specices: String) : Animal(){
    override fun makeSound() {
        println("${specices}")
    }

}

open class LinearCat(specices: String) : Cat(specices), Linear{
    override fun getlinearcnt(pattern : String) {
        val pattern = ""
    }

}


