package spice.declarations

import spice.Spice

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}