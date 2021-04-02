package lucasmarques.me.bcredi.domain.warranty

import lucasmarques.me.bcredi.domain.state.State
import lucasmarques.me.bcredi.domain.warranty.exception.InvalidStateError
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class WarrantyTest {

    @Test
    fun `Should create a new warranty with valid attributes`() {
        val amount = BigDecimal(50_000)

        val warranty = Warranty(amount, WarrantyType.PROPERTY, State.DF)

        assertEquals(warranty.amount, amount)
        assertEquals(warranty.type, WarrantyType.PROPERTY)
        assertEquals(warranty.state, State.DF)
    }

    @ParameterizedTest
    @ValueSource(strings = ["PR", "SC", "RS"])
    fun `Should create a new warranty with a invalid state`(stateValue: String) {
        val state = State.valueOf(stateValue)
        val amount = BigDecimal(50_000)

        Assertions.assertThrows(InvalidStateError::class.java) {
            Warranty(amount, WarrantyType.PROPERTY, state)
        }
    }

}