package com.example.androidstudy

fun main() {
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
    val filtered = numbers.getHigherThan(3).toString()
    println(filtered)

    val string1 = "asdfasdf"
    println(string1.checkIntOrNull())
    val string2 = "11111"
    println(string2.checkIntOrNull())
    println(string2.checkIntOrNull())
}

fun List<String>.getLongerThan(length: Int) = this.filter { length < it.length }

fun String.checkIntOrNull() = this.toIntOrNull()

fun getHigherThan(n:Int, list: List<Int>) =
    list.filter { n < it }

fun List<Int>.getHigherThan(n: Int) = filter { n < it }

fun printName(name: String?) {
    name?.let {
        println("My name is $name")
    } ?: run {
        println("I don't have name")
    }
}