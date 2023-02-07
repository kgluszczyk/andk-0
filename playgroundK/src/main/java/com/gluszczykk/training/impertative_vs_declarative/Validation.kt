package com.gluszczykk.training.impertative_vs_declarative

/** Ćwieczenie
 *
 * Przekształć formę imperatywną implementacje na deklaratywną
 * Po refaktorze upewnij się, że testy dalej przechodzą ;)
 */

fun List<Input>.validate(): List<ValidationError> {
    return this
        .filter { it.mandatory && (it is InputCheckbox && it.value?.fromApiBoolean() == true || it.validation != null) }
        .map { ValidationError(it.id, "Required") }
}