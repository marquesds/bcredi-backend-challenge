package lucasmarques.me.bcredi.domain.proposal

import lucasmarques.me.bcredi.domain.proposal.exception.InvalidLoanAmountError
import lucasmarques.me.bcredi.domain.proposal.exception.InvalidNumberOfWarrantiesError
import lucasmarques.me.bcredi.domain.warranty.Warranty
import java.math.BigDecimal
import java.util.*

data class Proposal(val id: UUID, val amount: BigDecimal, val warranties: List<Warranty>) {
    init {
        validateNumberOfWarranties()
        validateWarrantiesAmount()
    }

    private fun validateWarrantiesAmount() {
        val totalWarrantiesAmount = warranties.sumOf { it.amount }
        if (totalWarrantiesAmount < this.amount)
            throw InvalidLoanAmountError("$totalWarrantiesAmount is not greater or equal than ${this.amount}")
    }

    private fun validateNumberOfWarranties() {
        val miminumWarrantiesSize = 1
        if (warranties.size < miminumWarrantiesSize)
            throw InvalidNumberOfWarrantiesError("${warranties.size} is not a valid number of warranties")
    }

}
