package lucasmarques.me.bcredi.domain.fixture

import lucasmarques.me.bcredi.domain.state.State
import lucasmarques.me.bcredi.domain.warranty.Warranty
import lucasmarques.me.bcredi.domain.warranty.WarrantyType
import java.math.BigDecimal

object Fixtures {

    fun createWarranty(amount: BigDecimal = BigDecimal(50_000), state: State = State.DF): Warranty {
        return Warranty(amount, WarrantyType.PROPERTY, state)
    }

}