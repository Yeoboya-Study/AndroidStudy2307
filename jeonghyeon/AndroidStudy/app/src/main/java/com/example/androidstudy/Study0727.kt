package com.example.androidstudy

import java.lang.StringBuilder

fun main() {
//    fun printName(name : String?) {
//        name?.run {println("My name is $name ")} ?: run{println("I don't have name")}
//    }
//
//    printName(null)
//    printName("jeonhyeon")
//
//    print("22ws".checkIntOrNull())
//
//    print("ABCDEFG".sliceFrom(0))

    println(longer("abs", "gwaw").repeat(3))


}
// 문자열 a와 문자열 b가 주어질 때, 길이가 긴 문자열을 3번 출력하시오 .
fun longer(str1 : String, str2 : String) : String{
    if(str1.length > str2.length) return str1 else return str2
}

fun repeatToLonger(str1: String, str2: String, res : (Int) -> String){

}

fun String.repeat(count : Int) : String{
    val sb = StringBuilder()
    (0 until count).forEach{
        sb.append(this) }
    return sb.toString()
}



//문자가 숫자가 되면 변환 값 => 아니면 null
fun String.checkIntOrNull() : Int?{
    try {
        return this.toInt()
    }catch (e : Exception) {
        return null
    }
}

//String에서 문자열 길이가 n번째자리부터 반환
fun String.sliceFrom(number : Int) = this.slice(number-1 until this.length)

//String 배열에서 일정 길이 이상인 값 list 반환
fun List<String>.getLongerThan(number : Int) = this.filter{ it.length > number}



