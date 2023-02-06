package com.gluszczykk.training

import javax.management.Query.gt

/**
1. Napisz wyrażenie if/else, które wypisze "No to się wysypia" jeśli nie ma dzieci, i "Oj, będzie cieżko" jeśli ma

2. Napisz wyrażenie when, które przypisze do zmiennej "Nastolatek" jesli wiek jest pomiedzy 13-19, 'dorosły' 20-59 i "Senior" jeśli jest powyżej 60

3. Napisz pętle for, która wypisze wszystkie lata przestepne pomiedzy 2010 a 2020

4. Napisz pętle while, która wpisze do osobnej tablicy 5 pierwszych lat przestepnych

5. Napisz pętle do-while, która wypisze wszystkie lata z talbicy z pkt.4 do 2008 włącznie


 **/

internal val teenRange = 13..19
internal val adultRange = 20 .. 59

fun main(){

    //1
    if(hasKids){
        println("No to się wysypia")
    } else {
        println("Oj, będzie cieżko")
    }

    //2

    val type = when(age){
        in teenRange -> "Nastolatek"
        in adultRange -> "Dorosły"
        else -> "Senior"
    }
    println(type)

    //lub
    val type2 = when{
        age in teenRange -> "Nastolatek"
        age in adultRange -> "Dorosły"
        age > 60 -> "Senior"
        else -> "Dziecko"
    }
    println(type2)

    //3
    for(year in leapYears){
        if(year in 2010..2020){
            println(year)
        }
    }

    //lub
    for(index in leapYears.indices){
        if(leapYears[index] in 2010..2020){
            println(leapYears[index])
        }
    }

    //4
    println("4")
    var years: Array<Int> = emptyArray()
    val iterator = leapYears.iterator()
    while (iterator.hasNext() && years.size <= 5){
        years = years.plus(iterator.next())
    }
    years.forEach {
        println(it)
    }
}