package com.gluszczykk.training

/**
Zadeklaruj 5 zmiennych i przypisz do nich adekwatne wartości
1. Imię
2. Wiek
3. Czy ma dzieci
4. Stała grawitacyjna
5. Lista lat przestepnych ktore mineły od 2001

 **/
const val GRAVITY_CONSTANT = 6.67430E-11
val name = "Krzysztof"
val age = 30
val hasKids = true
val leapYears = arrayOf(2004, 2008, 2012, 2016, 2020)

fun main() {
    println("Imię: $name, wiek: $age ma dzieci: $hasKids, liczba lat przestępnych w XXI wieku: ${leapYears.size}")
    /* W przypadku tablicy, rozszerzenie jej o dodatkowy element wiąże się ze stworzeniem nowego obiektu.
       funkcja `plus(..)` pod spodem kopiuje starą tablicę, poszerzając nową o 1 element, do którego potem przypisuje wartość podaną jako argument.

        W celu wypisania zawartości tablicy na wynik funkcji `plus(..)` aplikujemy funkcję `foreach`
    */
    println("Lista lat przestępnych za 1-rok:")
    leapYears
        .plus(2024)
        .forEach {
            println(it)
        }
}