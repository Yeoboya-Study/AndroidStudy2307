package com.example.androidstudy

import android.view.View

fun main() {

    // 확장 함수
    "Can".print()

    //람다 함수

    var sum = { a : Int, b: Int, c: Int, d:Int -> a+b+c+d }

    print( sum(1,2,3,4) ) //실제로 인자를 받는 함수 처럼 사용이 가능함



    //====================================다양한 클래스==================================
    //data class
    val A = People("And", 22)
//    People(22) : 인자가 부족하기 때문에 불가능함
    print(A.toString())   //Cancom.example.androidstudy.People@7a0ac6e3 > 주소값 반환

    print(A.age)
    //    A.name ="dko"  // val로 생성하면 setter접근 불가

    val B = PeopleData("김수한무거북이가")   //나이는 초기값이 있어서 이러한 오버로딩이 가능함

    print(B.toString())  //PeopleData(name=and, age=1) String형태로 반환해주는 특징이 있음
    
    val C = Peo("정")

//    print(C.name) getter, setter를 생성해주지만 private에서는 안됨
//    C.name = "ss"

    print( Peo().name )

    People("name")

    //enum class




    //sealed class





    //인터 페이스, 추상 클래스
    //class확장과 구현 모두  : 로 표시함  // 함수에서는 :는 return
    println()
    println(numClass("ee").name)

    println(nomClass().name)
    nomClass().min()

    //상속 => open class로 진행함

    println( Child().name)
    

    //함수형, 객체 지향형 프로그래밍의 개념

}

//데이터 클래스
class Peo constructor(name : String){
    val name : String
    init{
        this.name = name
    }

    //부 생성자도 만들수 있음
    constructor() : this("anonymous")


}
//constructor생략가능

class People(val name : String, age : Int) {
    // name처럼 매개변수에서 생성자 선언이 가능함
    val age : Int
        init{
            this.age = age
        }   

    constructor(name: String) : this( name, 11){
        print("성공")
    }
    //기본 형식은 age처럼 진행
}

data class PeopleData(val name : String, val age: Int?=1) {
    // age와 같이 작성하게 되면 null값이 들어올때 1로 초기화 해줌
    // 즉, overloading이 가능함
//    toString(), copy(), hashCode(), equals() 를 생성해주는게 특징

    //init을 활용하면 예외 처리 구문도 구현이 가능함
    init {
        if (name.length < 5) throw ShortName("이름이 너무 짧습니다 20자 이상으로 해주세요")
    }

    fun ShortName(err: String): Throwable {
        return TODO(err)
    }
}


interface oneInter {
    fun add()
    fun min() :Unit {
        print("min1")
    }   //defaul 메서드는 그냥 구현하면됨
}

interface twoInter {
    val name : String //프로퍼티 생성시에 getter가 생성됨
    fun add()
    fun min(): Unit {
        print("min2")
    }   //defaul 메서드는 그냥 구현하면됨
}

//포로퍼티는 다음과 같이 인자로 받을 수 있고 이때 { return nickname } 가 getter()에 자동으로 구현됨
class numClass(override val name: String) : oneInter, twoInter {

    //두개 다 상속받을 수는 있음
    // 그런데 같은 이름의 메서드가 있다? 구현에 주의할 것
    
    //제네릭을 통해서 어떤 인터페이스를 활용할 것인지 설정이 가능함
    override fun min(){
        super<oneInter>.min()
    }
    
    //add는 하나만 해줘도 됨
    override fun add(){
        print("add")
    }

}

class nomClass() : oneInter, twoInter {

    //받는게 싫으면 그냥 내가 해도됨
    override val name: String = "alex"
    
    override fun min(){
        super<oneInter>.min()
        super<twoInter>.min()
    }

    //add는 하나만 해줘도 됨
    override fun add(){
        print("add")
    }

}

open class Parent(val name: String){
    constructor() : this("ree")
}

class Child : Parent {

    constructor() : super("neeeeeeeeeee")

}