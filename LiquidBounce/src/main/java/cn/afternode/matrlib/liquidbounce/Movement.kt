package cn.afternode.matrlib.liquidbounce

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

object Movement {
    @JvmStatic
    fun getSpeed(motionX: Float, motionZ: Float): Float {
        return sqrt(motionX * motionX + motionZ * motionZ)
    }

    /**
     * Returns an array containing new motionX and motionZ ([motionX, motionZ])
     */
    @JvmStatic
    fun calculateStrafe(loc: Location, motionX: Float, motionZ: Float, speed: Float = getSpeed(motionX, motionZ)): Array<Float> {
        return arrayOf(-sin(loc.yaw) * speed, cos(loc.yaw) * speed)
    }
}