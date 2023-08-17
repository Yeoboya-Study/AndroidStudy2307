package com.example.androidstudy.chap05

open class Bird(var name: String, var wing:Int, var beak: String, var color: String){
    // var나 val을 써주는것 : 자바의 필드(코틀린의 프로퍼티)
//메서드
    fun fly()=println("Fly wing : $wing")
    fun sing(vol:Int)=println("Sing vol:$vol")
}

//하위클래스의 생성자에는 상위클래스의 생성자프로퍼티를 모두 초기화해야함
// 주 생성자를 사용하는 상속
// 주생성자 > Bird에서 초기화
class Lark(name:String, wing:Int, beak:String, color:String):Bird(name,wing,beak,color){
    fun singHitone()=println("Happy Song!")
}

// 부 생성자를 사용하는 상속
// constructor > super(Bird)에서 초기화 > 추가된 프로퍼티 language초기화
class Parrot:Bird{
    // 추가된 프로퍼티
    val language:String
    constructor(name:String,wing:Int,beak:String, color:String,
                language:String):super(name,wing,beak,color){
        // super: 상위클래스인 Bird를 가리킴
        this.language=language
    }
    fun speak()=println("Speak! $language")
}

fun main(){
    val coco=Bird("mybird",2,"short","blue")
    val lark=Lark("mylark",2,"long","brown")
    val parrot=Parrot("myparrot",2,"short","multiple","korean")
    println("coco:${coco.name},${coco.wing},${coco.beak},${coco.color}")
    println("Lark:${lark.name},${lark.wing},${lark.beak},${lark.color}")
    println("Parrot:${parrot.name},${parrot.wing},${parrot.beak},${parrot.color},${parrot.language}")

    lark.singHitone()// 새로 추가된 메서드 사용가능
    parrot.speak()
    lark.fly()

}

// 하위클래스는 상위클래스의 메서드나 프로퍼티를 그대로 상속하면서 추가로 자신의 메소드,프로퍼티 확장