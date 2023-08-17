package com.example.androidstudy.chap07

interface Bird{
    val wings:Int
    fun fly()
    fun jump()= println("bird jump!")
}

interface Horse{
    val maxSpeed:Int
    fun run()
    fun jump()= println("jump!, max speed: $maxSpeed")
}

class Pegasus: Bird,Horse{
    override val wings: Int =2
    override fun fly()= println("Fly!")
    override val maxSpeed: Int = 100
    override fun run()= println("Run!")
    override fun jump() {
        super<Horse>.jump()
        println("and jump!")
    }
}

