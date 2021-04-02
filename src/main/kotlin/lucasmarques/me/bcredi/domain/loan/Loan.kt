package lucasmarques.me.bcredi.domain.loan

import lucasmarques.me.bcredi.domain.loan.exception.InvalidAmountError
import lucasmarques.me.bcredi.domain.loan.exception.InvalidTermError
import java.math.BigDecimal
import java.util.*

data class Loan(val id: UUID, val amount: BigDecimal, val term: Int, val proposalId: UUID) {
    init {
        validateAmount()
        validateTerm()
    }

    private fun validateAmount() {
        val minimumAmount = BigDecimal(30_000)
        val maximumAmount = BigDecimal(3_000_000)
        if (this.amount < minimumAmount || this.amount > maximumAmount)
            throw InvalidAmountError("${this.amount} is not a valid amount.")
    }

    private fun validateTerm() {
        if (this.term < 24 || this.term > 180)
            throw InvalidTermError("${this.term} is not a valid term.")
    }
}