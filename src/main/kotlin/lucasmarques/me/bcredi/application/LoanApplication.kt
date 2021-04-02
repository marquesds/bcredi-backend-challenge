package lucasmarques.me.bcredi.application

import lucasmarques.me.bcredi.domain.loan.Loan

interface LoanApplication {

    fun createLoanProposal(proposal: ProposalDTO): Loan

}