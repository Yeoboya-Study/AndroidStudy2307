package com.example.androidstudy.chap07.CatAndDog

open class Animal(val name: String)

interface Pet{
    var category:String
    var species:String
    fun feeding()
}

class Dog(name: String, override var category: String):Animal(name),Pet{
    override fun feeding() {
        println("Feed the dog a bone")
    }

    override var species: String = "dog"
}

class Cat(name: String, override var category: String):Animal(name),Pet{
    override fun feeding() {
        println("Feed the cat a tuna")
    }
    override var species: String = "cat"
}

class Master{
    // 인터페이스를 객체로 매개변수 지정
    fun playWithPet(pet:Pet){
        println("Enjoy with my ${pet.species}")
    }

}

fun main(){
    val master = Master()
    val dog = Dog("Toto","Small")
    val cat = Dog("Coco","BigFat")
    master.playWithPet(dog)
    master.playWithPet(cat)
}