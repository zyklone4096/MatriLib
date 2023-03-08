package cn.afternode.matrilib.distancereborn.utils

import org.bukkit.entity.Entity
import kotlin.math.atan2
import kotlin.math.sqrt

object RotationUtil {
    @JvmStatic
    fun getRotations(entity: Entity, from: Entity): FloatArray {
        val diffX: Double = entity.location.x - from.location.x
        val diffZ: Double = entity.location.z - from.location.z
        val diffY: Double = (entity.location.y + (entity.location.y + 1 - 0.4)
                    - (from.location.y + from.location.y+1))
        val dist: Double = sqrt(diffX * diffX + diffZ * diffZ)
        val yaw = (atan2(diffZ, diffX) * 180.0 / 3.141592653589793).toFloat() - 90.0f
        val pitch = (-atan2(diffY, dist) * 180.0 / 3.141592653589793).toFloat()
        return floatArrayOf(yaw, pitch)
    }
}