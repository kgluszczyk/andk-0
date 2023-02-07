package com.gluszczykk.training

fun main() {
    //Any -> Number -> Double ->Nothing
    var numery = Array<Number>(3) { 1 }
    val double = Array<Double>(3) { 2.0 }

    var numer: Number = 1
    numer = 1.0

    //Nie zadziała, ponieważ tablica jest mutowalna - unikamy run time exception
    //numery = double

    var listaNumerow = List<Number>(3) { 1 }
    val listaDouble = List<Double>(3) { 2.0 }
    listaNumerow = listaDouble

    var listaNumerowMutowalna = MutableList<Number>(3) { 1 }
    val listaDoubleMutowalna = MutableList<Double>(3) { 2.0 }

    //Nie zadziała, ponieważ lista jest mutowalna - unikamy run time exception
    //listaNumerowMutowalna = listaDoubleMutowalna

    //Consumer (wartosc przipisana 'write' In Producent (wartość zwracana aka. read) out
}