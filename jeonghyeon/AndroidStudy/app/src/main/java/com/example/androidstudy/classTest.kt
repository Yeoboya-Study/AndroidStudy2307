package com.example.androidstudy

fun main() {
    val seed : Rice = Rice()

    seed.rice = Rice.State.GOOD
    seed.print()

    print(Pn.name)

    print(Tool.name)

    //익명객체로 전화기 구현
    var tel = object : Speaker {
        override fun pop() {
            println("Rrrrrrrrr...")
        }
    }
    tel.pop()

}

class Rice{

    var rice : State = State.GOOD

    fun print() = rice.print()

    enum class State{
        GOOD {
            override fun print(){
                println("GOOD")
            }
        };

        abstract fun print()
    }
}

class Pn{
    companion object{
        val name = "SOFI"
    }
}

//===========================object 활용 ===========================

//싱글톤 객체
object Tool {
    val name = "Spanner"
}

//익명 객체
interface Speaker {
    fun pop()
}