package com.example.androidstudy.chap07

/*
데이터 클래스 : DTO를 표현하기 적합한 클래스 필드+게터/세터
- 자동생성메서드 : 프로퍼티 게터세터
                equals()
                hashCode()
                객체자체프린트시 toString()사용한것과 같다
                copy()
                프로퍼티에 상응하는 componentN() ex)component1()


- abstract,open,sealed,inner 키워드 사용불가
- 간단한 로직 : 부생성자나 init블록
 */

data class Customer(var name:String, var email:String){ // 주 생성자는 최소한 하나의 매개변수를 가져야하고 val이나 var로 지정해야한다
    var job:String="UnKnown"
    constructor(name: String,email: String,_job:String):this(name,email){
        job=_job
    }
    init{
        this.name = "Mr/Ms"+this.name
    }
}

fun main(){

    val cus1=Customer("Sean","sean@mail.com")
    val (name,email)=cus1 //객체 디스트럭처링(소괄호사용해서 데이터변수 나눔)
    println("name=$name,email=$email")

    val n1=cus1.component1() //첫번째 주생성자 프로퍼티
    val n2=cus1.component2() //두번째 주생성자 프로퍼티
    val n3=cus1.job
    println("name=$n1 , email=$n2, job=$n3")

    val lam1={
            (name,email):Customer->{
        println(name)
        println(email)
    }
    }
    lam1(cus1)

    val cus2=Customer("Sean","sean@mail.com")

    println(cus1==cus2)
    println(cus1.equals(cus2))
    println("${cus1.hashCode()},${cus2.hashCode()}")
    val cus3= cus1.copy(name="Alice")// name만 변경
    println(cus1.toString())
    println(cus2.toString())



}

/*
객체 데이터가 많다? for문으로 돌리자
    val cus1=Customer("Sean","sean@mail.com")
    val cus2=Customer("Sean","sean@mail.com")
    val bob=Customer("bob","bob@mail.com")
    val erica = Customer("Erica","erica@mail.com")


val customers = listOf(cus1,cus2,bob,erica)

    for((name,email)in customers){
        println("name:$name,email:$email")
    }



*/


