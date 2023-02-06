package com.gluszczykk.training

/**
1. Napisz funckję sprawdzajaca czy dany dany wiek odpowiada nastolatkowi

2. Napisz funkcję, która wypisze "Cześć, [imię]" dla podanego imienia

3. Napisz funkcję wyższego rzędu, która przyjmuje jako argument:
 * tablicę lat,
 * funkcje dodającą 1 rok lub funkcję sumującą cyfry z danego roku, której wynika aplikacji zastąpi każdy element do którego została zaaplikowana

Wykonaj fukcję i wypisz tablicę na standardowe wyjśćie.


 **/
typealias ProcessInt = (Int) -> Int

fun main() {

    //1
    fun isTeen(age: Int) = age in teenRange

    println(isTeen(16))
    //lub
    isTeen(30).also { teensAge ->
        println(teensAge)
    }
    //ekwiwalent
    val isTeen30 = isTeen(30)
    println(isTeen30)

    isTeen(30).run {
        println(this)
    }

    //2
    fun hello(name: String) = println("Cześć, $name")
    hello("Kris")

    //3
    fun processIntArray(years: Array<Int>, processAction: ProcessInt) {
        years.forEach {
            println(processAction(it))
        }
    }

    processIntArray(leapYears) {
        it + 1
    }

    //lub
    processIntArray(leapYears) { year ->
        year.toString().sumOf { char -> char.toString().toInt() }
    }

}