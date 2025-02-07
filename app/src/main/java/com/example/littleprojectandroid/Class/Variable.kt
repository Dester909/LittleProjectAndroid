package com.example.littleprojectandroid.Class

//class Variable {
//}
fun main(){
    //Numeric variables
    val age:Int =20
    val long_number:Long = 789123128937
    val temperature:Float = 27.33f
    val weight:Double = 64.1231

    //String variables
    val gender:Char = 'M'
    val name:String = "Marco"

    //Bool variables
    val isGreater:Boolean = false

    //Collection variables
    val names = arrayOf("Erick", "Sofia", "Javier", "Veronica")

    println(age)
    println("Welcom $name, to your first Kotlin Project ")
    println(add())
    println(product(10,10))
    printArray(names)

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    isEven(numbers)
    println(getday(1))

    val person = Person("Marco",20)
    println(person.name)
    println(person.age)
    person.displayInformation()

}

fun isEven(numbers:Array<Int>){
    for(number in numbers){
        if(number % 2 == 0)
            println("the number $number is Even")
        else {
            println("the number $number isn't Even")
        }
    }
}
fun getday(day:Int):String{
    var name = ""

    when(day){
        1 -> name = "Monday"
        2 -> name = "Thuesday"
        3 -> name = "Wendsday"
        4 -> name = "Thursday"
        5 -> name = "Friday"
        6 -> name = "Saturday"
        7 -> name = "Sunday"
        else -> name = "Incorrect value"
    }
    return name
}

class Person(val name:String, val age:Int){
    fun displayInformation(){
        println("Name:$name  Age:$age")
    }
}

fun add():Int{
    val x = 10
    val y = 5
    return(x + y)
}

fun product(x:Int, y:Int):Int{
    return(x * y)
}

fun printArray(names:Array<String>){
    println(names)
    for(name in names){
        println("Hola $name")
    }/*Agregamos un cliclo tipo for para que recorra la cantidad de Arrays que existen*/

}