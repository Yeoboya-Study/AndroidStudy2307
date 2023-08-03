package com.example.androidstudy

fun main(){
    var number : Int? = 0
    var name : String? = null

    fun introduce(name: String?){
        name?. let{
            println("안녕하세요 ${name}입니다.")
        }?:{
            println("이름을 다시 입력해주세요.")
        }
    }
    // 문자열이 숫자로 변환 >  숫자아닌경우 >  null반환하는 확장함수
    fun String.strToInt(){
        this.toIntOrNull()
    }

// 문자열의 길이가 n을 초과 한쪽만 반환
   fun List<String>.test() {

}
}

