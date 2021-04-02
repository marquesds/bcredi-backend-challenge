package lucasmarques.me.bcredi.domain.proponent

import lucasmarques.me.bcredi.domain.proponent.exception.InvalidAgeError
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class ProponentTest {

    @Test
    fun `Should create a new proponent with valid attributes`() {
        val age = 18
        val income = BigDecimal(5_000)
        val proponent = Proponent(UUID.randomUUID(), age, income, true, UUID.randomUUID())

        assertEquals(proponent.age, age)
        assertEquals(proponent.income, income)
    }

    @ParameterizedTest
    @ValueSource(ints = [17, -45])
    fun `Should not create a new proponent with an invalid age`(invalidAge: Int) {
        Assertions.assertThrows(InvalidAgeError::class.java) {
            Proponent(UUID.randomUUID(), invalidAge, BigDecimal(5_000), true, UUID.randomUUID())
        }
    }

}