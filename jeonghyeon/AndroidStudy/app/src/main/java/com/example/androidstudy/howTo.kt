package com.example.androidstudy

fun main() {

    println(higher("abbb", "bbab", resolve))

    val test = Tester()
    test.printLan()
    test.lan = Tester.Type.Java
    test.printLan()
}


fun higher( a : String, b : String, pro : (String, String)->Int) : Int {
    return pro(a,b)
}

val resolve = fun (A : String, B:String): Int {

    var alist = A.map{it}.toMutableList()
    var blist = B.map{it}.toMutableList()

    for(i in 0 until alist.size){
        if(alist != blist){
            alist.add(0, alist.last())
            alist.removeLast()
        }else{
            return i
        }
    }
    return -1
}


class Tester {

    var lan : Type = Type.Kotlin

    fun printLan() =
        when(lan){
            Type.Java -> println("Java")
            Type.Kotlin -> println("Kotlin")
            else -> println("C")
        }

    enum class Type {
        Java, Kotlin, C
    }
}