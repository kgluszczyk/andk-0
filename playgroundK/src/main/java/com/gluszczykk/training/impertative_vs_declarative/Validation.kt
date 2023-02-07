package com.gluszczykk.training.impertative_vs_declarative

/** Ćwieczenie
 *
 * Przekształć formę imperatywną implementacje na deklaratywną
 * Po refaktorze upewnij się, że testy dalej przechodzą ;)
 */

fun List<Input>.validate(): List<ValidationError> {
    val result = mutableListOf<Input>()
    for (i in indices) {
        if (this[i].mandatory) {
            result.add(this[i])
        }
    }
    val result2 = mutableListOf<Input>()
    for (i in result.indices) {
        if (result[i] is InputCheckbox) {
            if (result[i].value?.fromApiBoolean() == true) {
                result2.add(this[i])
            }
        } else if (result[i].validation != null) {
            result2.add(this[i])
        }
    }
    val result3 = mutableListOf<ValidationError>()
    for (i in result2.indices) {
        result3.add(ValidationError(result2[i].id, "Required"))
    }
    return result3
}