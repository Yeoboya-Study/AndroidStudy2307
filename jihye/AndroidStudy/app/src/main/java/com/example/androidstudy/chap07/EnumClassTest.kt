package com.example.androidstudy.chap07

interface Score{
    fun gerScore():Int
}

enum class  MemberType(var prio:String):Score{
    NORMAL("Third"){
        override fun gerScore(): Int = 100
    },
    SILVER("Second"){
        override fun gerScore(): Int = 500
    },
    Gold("First"){

        override fun gerScore(): Int = 1500
    }
    }

fun main(){
    println(MemberType.NORMAL.gerScore())
    println(MemberType.Gold)
    println(MemberType.valueOf("SILVER"))
    println(MemberType.valueOf("NORMAL"))

    println(MemberType.SILVER.prio)

    for(grade in MemberType.values()){
        println("grade.name = ${grade.name}, prio=${grade.prio}")}
    }
