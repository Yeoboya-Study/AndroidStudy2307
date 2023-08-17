package com.example.androidstudy.chap05

// 다형성

// 오버라이딩 : 기능을 완전히 다르게 바꾸어 재설계
// 			ex) 누르다 > 행위 > push() 확인 혹은 취소용도로 서로 다른 기능을 수행
// 			부모클래스에 open / 자식 클래스에 override(메서드,프로퍼티)

// 오버로딩 : 기능은 같지만 이자를 다르게 하여 여러경우를 처리
// 			ex) 출력한다 > 행위 > print()
// 			print(123),print("Hello")>> 인자는 다르지만 출력기능은 동일하다


//클래스 오버로딩
fun main(){
    val calc=Caic()
    println(calc.add(3,2))
    println(calc.add(3.2,1.3))
    println(calc.add(3,3,2))
    println(calc.add("Hello","World"))

}

class Caic{
    // 다양한 매개변수로 오버로딩
    fun add(x:Int, y:Int):Int = x+y
    fun add(x:Double, y:Double):Double = x+y
    fun add(x:Int, y:Int,z:Int):Int = x+y+z
    fun add(x:String, y:String):String=x+y


}