package lucasmarques.me.bcredi.application

import lucasmarques.me.bcredi.domain.loan.Loan
import lucasmarques.me.bcredi.domain.proponent.Proponent

class LoanApplicationImpl : LoanApplication {
    override fun createLoanProposal(proposal: ProposalDTO): Loan {
        TODO("Not yet implemented")
    }

    fun validateExistenceOfMainProponent(proponents: List<Proponent>) {
    }

    fun validateNumberOfProponents(proponents: List<Proponent>) {
    }

    fun validateProponentsTotalIncome(proponents: List<Proponent>) {
    }
}