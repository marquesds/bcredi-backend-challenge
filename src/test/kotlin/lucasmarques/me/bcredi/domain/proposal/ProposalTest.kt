package lucasmarques.me.bcredi.domain.proposal

import lucasmarques.me.bcredi.domain.fixture.Fixtures
import lucasmarques.me.bcredi.domain.proposal.exception.InvalidLoanAmountError
import lucasmarques.me.bcredi.domain.proposal.exception.InvalidNumberOfWarrantiesError
import lucasmarques.me.bcredi.domain.warranty.Warranty
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals

class ProposalTest {

    @ParameterizedTest
    @ValueSource(ints = [500_000, 600_000])
    fun `Should create a new proposal with valid attributes`(warrantyAmountInt: Int) {
        val warrantyAmount = BigDecimal(warrantyAmountInt)
        val warranties = listOf(
            Fixtures.createWarranty(amount = warrantyAmount),
            Fixtures.createWarranty(amount = warrantyAmount)
        )

        val amount = BigDecimal(1_000_000)
        val proposal = Proposal(UUID.randomUUID(), amount, warranties)

        assertEquals(proposal.amount, amount)
        assertEquals(proposal.warranties, warranties)
    }

    @ParameterizedTest
    @ValueSource(ints = [499_000, 30_000, -50])
    fun `Should raise an error when sum of warranties is lower than the loan amount`(warrantyAmountInt: Int) {
        val warrantyAmount = BigDecimal(warrantyAmountInt)
        val warranties = listOf(
            Fixtures.createWarranty(amount = warrantyAmount),
            Fixtures.createWarranty(amount = warrantyAmount)
        )

        val amount = BigDecimal(1_000_000)
        Assertions.assertThrows(InvalidLoanAmountError::class.java) {
            Proposal(UUID.randomUUID(), amount, warranties)
        }
    }

    @Test
    fun `Should raise an error when number of warranties is not enough`() {
        val warranties = emptyList<Warranty>()

        val amount = BigDecimal(1_000_000)
        Assertions.assertThrows(InvalidNumberOfWarrantiesError::class.java) {
            Proposal(UUID.randomUUID(), amount, warranties)
        }
    }

}