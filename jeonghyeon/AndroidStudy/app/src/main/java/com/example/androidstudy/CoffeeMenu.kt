package com.example.androidstudy

interface CoffeeMenu : Menu{

//    //Menu interface // 이름과 가격은 메뉴의 종류별로 다르게 나타남
//    //인터페이스는 구현 해야 되는 속성에 대해서 정의 해줄때, 추상 클래스는
//    override var price: Int
//    override val name: String

    var temperature: Temperature


    //옵션이 있는 Americano만 다시 구현해줄 것
    override fun getMenu() {
        try {
            print("$temperature $name 나왔습니다. 가격은 ${price}원 입니다")
        }catch(error : UninitializedPropertyAccessException){
            print("온도를 설정 해 주세요")
        }
    }

    //enum class
    //커피 관련 음료는 핫/아이스 옵션 선택이 가능 하다.
    enum class Temperature(value: String?) {
        Hot("Hot"), Ice("Ice")
    }
}