package com.example.androidstudy.chap05

// 현재 클래스에서 참조의 기능
// 상위클래스: super 키워드
// 현재클래스 : this 키워드로 참조
// 생성자를 구성할때는 반드시 상위클래스에 있는 내용을 호출해서 초기화해서 와야함!!



open class Person{
    constructor(firstName: String){
        println("[Person] firstName:$firstName,")
    }
    constructor(firstName: String,age:Int){
        println("[Person] firstName:$firstName,$age")
    }

}

class Developer:Person{
    constructor(firstName: String):this(firstName,10){
        // 여기서 this는 현재 클래스내에서 처리할 수 있는 부생성자를 가리킴
        println("[Developer] firstName:$firstName")
    }
    constructor(firstName: String,age:Int):super(firstName,age){
        // 여기서 super는 상위생성자를 가리킴
        println("[Developer] firstName:$firstName,$age")
    }
}

fun main(){
    val sean = Developer("Sean")
}