package lucasmarques.me.bcredi.domain.proponent

import lucasmarques.me.bcredi.domain.proponent.exception.InvalidAgeError
import java.math.BigDecimal
import java.util.*

data class Proponent(val id: UUID, val age: Int, val income: BigDecimal, val isMain: Boolean, val proposalId: UUID) {
    init {
        validateAge()
    }

    private fun validateAge() {
        val minimumAge = 18
        if (this.age < minimumAge)
            throw InvalidAgeError("${this.age} is not a valid age.")
    }
}
