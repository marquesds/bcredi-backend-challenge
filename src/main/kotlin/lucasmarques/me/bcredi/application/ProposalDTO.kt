package lucasmarques.me.bcredi.application

import lucasmarques.me.bcredi.domain.proponent.Proponent
import lucasmarques.me.bcredi.domain.warranty.Warranty
import java.math.BigDecimal

data class ProposalDTO(val proponents: List<Proponent>, val warranties: List<Warranty>, val proposalAmount: BigDecimal)
