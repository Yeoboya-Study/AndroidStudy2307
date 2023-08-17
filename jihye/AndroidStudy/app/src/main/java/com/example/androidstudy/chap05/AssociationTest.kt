package com.example.androidstudy.chap05

class Patient(val name:String){
    fun doctorList(d: Doctor){ //인자로 참조
        println("Patient: $name,Doctor:${d.name}")
    }
}

class Doctor(val name:String){
    fun patientList(p:Patient){ // 인자로 참조
        println("Doctor: $name, Patient:${p.name}")
    }
}

fun main(){
    val doc1 = Doctor("Kim") // 객체 따로 생성
    val patient1 = Patient("Lee")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}