package com.example.androidstudy


// 동물 클래스 (추상 클래스)
abstract class Animal {
    abstract val species: String
    abstract fun makeSound()
}

// 고양이 클래스 (open 클래스)
open class Cat : Animal() {
    override val species = "Cat"

    override fun makeSound() {
        println("$species says Meow!")
    }
}

// 개 클래스 (open 클래스)
open class Dog : Animal() {
    override val species = "Dog"

    override fun makeSound() {
        println("$species says Woof!")
    }
}

// 점박이 특징
interface DottedPattern {
    val pattern: String get() = "dotted"

    fun getDotCnt(): Int
}

// 줄무늬 특징
interface LinearPattern {
    val pattern: String get() = "linear"

    fun getLinearCnt(): Int
}

class Kitty: Cat(), DottedPattern {
    override fun getDotCnt(): Int {
        println("Kitty has three big dots.")
        return 3
    }
}

class Nabi: Cat(), LinearPattern {
    override fun getLinearCnt(): Int {
        println("Nabi has lots of lines")
        return 50
    }
}

class Puppy: Dog(), DottedPattern {
    override fun getDotCnt(): Int {
        println("Puppy has 26 small dots")
        return 26
    }
}

class Bbobbi: Dog(), LinearPattern {
    override fun getLinearCnt(): Int {
        println("Bbobbi has 2 lines on face")
        return 2
    }
}