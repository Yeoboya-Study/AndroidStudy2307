package com.example.androidstudy

class Americano : CoffeeMenu{

    override val name: String = "아메리카노"
    override var price: Int = 4000

    //옵션 기본 선택 안됨
    var option : Option = Option.None

    //온도 설정 필수
    override lateinit var temperature: CoffeeMenu.Temperature


    override fun getMenu() {
        try {
            option.value?.let{ print("${option}을 추가한 ") }
            print("$temperature $name 나왔습니다. 가격은 ${price}원 입니다")
        }catch(error : UninitializedPropertyAccessException){
            print("온도를 설정 해 주세요")
        }
    }



    enum class Option(var value : String?) {
        None(null) , Vanilla("바닐라"), Almond("아몬드");
    }
}