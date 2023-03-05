package cn.afternode.matrlib.liquidbounce.other

import org.bukkit.Location
import kotlin.jvm.internal.Intrinsics

object DreamMore {
    @JvmStatic
    fun calculateCriticalLocation(d: Double, d2: Double, d3: Double, bl: Boolean, n: Int, loc: Location, look: Boolean = false): Location {
        var dl1 = d
        var dl2 = d2
        var dl3 = d3
        if (n and 1 !== 0) {
            dl1 = 0.0
        }
        if (n and 2 !== 0) {
            dl2 = 0.0
        }
        if (n and 4 !== 0) {
            dl3 = 0.0
        }
        return calculateCriticalLocation(dl1, dl2, dl3, bl, loc, look)
    }

    @JvmStatic
    private fun calculateCriticalLocation(xOffset: Double, yOffset: Double, zOffset: Double, ground: Boolean, loc: Location, look: Boolean): Location{
        val x: Double = loc.x + xOffset
        val y: Double = loc.y + yOffset
        val z: Double = loc.z + zOffset
        return if (look) {
            val f: Float = loc.yaw
            Location(
                loc.world,
                x,
                y,
                z,
                f,
                loc.pitch
            )
        } else {
            Location(loc.world, x, y, z, loc.yaw, loc.pitch)
        }
    }
}