package lucasmarques.me.bcredi.domain.loan

import lucasmarques.me.bcredi.domain.loan.exception.InvalidAmountError
import lucasmarques.me.bcredi.domain.loan.exception.InvalidTermError
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class LoanTest {

    @Test
    fun `Should create a new Loan with a valid amount and term`() {
        val amount = BigDecimal(50_000)
        val term = 24

        val loan = Loan(UUID.randomUUID(), amount, term, UUID.randomUUID())

        assertEquals(loan.amount, amount)
        assertEquals(loan.term, term)
    }

    @ParameterizedTest
    @ValueSource(doubles = [3_000.0, 5_000_000.0])
    fun `Should not create a new Loan with an invalid lower or greater amount`(amountDouble: Double) {
        val amount = BigDecimal(amountDouble)
        Assertions.assertThrows(InvalidAmountError::class.java) {
            Loan(UUID.randomUUID(), amount, 24, UUID.randomUUID())
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [23, 181])
    fun `Should not create a new Loan with an invalid lower or greater term`(term: Int) {
        Assertions.assertThrows(InvalidTermError::class.java) {
            Loan(UUID.randomUUID(), BigDecimal(30_000), term, UUID.randomUUID())
        }
    }

}