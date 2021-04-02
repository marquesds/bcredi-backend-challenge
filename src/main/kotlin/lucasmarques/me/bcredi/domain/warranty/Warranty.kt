package lucasmarques.me.bcredi.domain.warranty

import lucasmarques.me.bcredi.domain.state.State
import lucasmarques.me.bcredi.domain.warranty.exception.InvalidStateError
import java.math.BigDecimal

data class Warranty(val amount: BigDecimal, val type: WarrantyType, val state: State) {

    init {
        validateState()
    }

    private fun validateState() {
        if (this.state in listOf(State.PR, State.SC, State.RS))
            throw InvalidStateError("${this.state} is not a valid state.")
    }

}
