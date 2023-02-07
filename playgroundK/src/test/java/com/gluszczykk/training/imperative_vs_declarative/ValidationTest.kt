package com.gluszczykk.training.imperative_vs_declarative

import assertk.assertThat
import assertk.assertions.containsOnly
import com.gluszczykk.training.impertative_vs_declarative.*
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ValidationTest {

    @Test
    fun `verify validation`() {
        //given
        val inputs = listOf(
            mockk<Toggle> {
                every { mandatory } returns true
                every { value } returns null
                every { id } returns 1
                every { validation } returns null
            }, mockk<Toggle> {
                every { validation } returns mockk {}
                every { mandatory } returns true
                every { value } returns null
                every { id } returns 2
            }, mockk<InputCheckbox> {
                every { value } returns "true"
                every { mandatory } returns true
                every { id } returns 3
                every { validation } returns null
            }, mockk<Toggle> {
                every { mandatory } returns false
                every { value } returns null
                every { id } returns 4
                every { validation } returns null
            }, mockk<InputCheckbox> {
                every { value } returns "false"
                every { mandatory } returns true
                every { id } returns 5
                every { validation } returns null
            }, mockk<Toggle> {
                every { mandatory } returns false
                every { value } returns null
                every { id } returns 6
                every { validation } returns null
            }
        )

        //when
        val errors = inputs.validate()

        //then
        assertThat(errors).containsOnly(
            ValidationError(id = 2, message = "Required"),
            ValidationError(id = 3, message = "Required")
        )
    }
}