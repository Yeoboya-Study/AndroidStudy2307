package com.example.androidstudy.chap04

fun main(){
    print("Enter the score: ")
    val score = readLine()!!.toDouble()// readLine: 콘솔로부터 입력받는다
    // ?.을 사용하고싶다면 >>> null검사를 먼저 해야한다
    var grade: Char = 'F'

    if(score>=90.0){
        grade = 'A'
    }else if(score>=80.0 && score<=89.9){
        grade = 'B'
    }else if(score in 70.0..79.9){
        // 범위 연산자 in 사용시 시작과 끝값이 포함된다
        grade = 'C'
    }
    println("Score : $score, Grade:$grade")
}