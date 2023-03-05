package cn.afternode.matrlib.liquidbounce

import org.bukkit.Location
import org.bukkit.entity.Entity
import kotlin.math.cos
import kotlin.math.sin

object Velocity {
    enum class VelocityType {
        // LiquidBounce
        Jump,

        // Pride
        Feile
    }

    fun calculateVelocity(type: VelocityType, e: Entity): Array<VelocityMotionData> {
        val list = ArrayList<VelocityMotionData>()

        when (type.name) {
            "Jump" -> {
                list.addAll(calculateLBVelocity(type, e))
            }
            "Fiele" -> {
                list.addAll(calculatePrideVelocity(type, e))
            }
        }

        return list.toTypedArray()
    }

    private fun calculateLBVelocity(type: VelocityType, e: Entity): List<VelocityMotionData> {
        val list = ArrayList<VelocityMotionData>()

        when (type.name) {
            "Jump" -> {
                val yaw = e.location.yaw * 0.017453292F
                list.add(VelocityMotionData(sin(yaw) * 0.2, 0.0, cos(yaw) * 0.2))
            }

        }

        return list
    }

    private fun calculatePrideVelocity(type: VelocityType, e: Entity): List<VelocityMotionData> {
        val list = ArrayList<VelocityMotionData>()

        when (type.name) {
            "Feile" -> {
                if (e.isOnGround) {
                    list.add(VelocityMotionData(1.5, 1.2, 1.5))
                } else {
                    list.add(VelocityMotionData(0.0,0.0,0.0))
                }
            }
        }

        return list
    }

    data class VelocityMotionData(val motionX: Double, val motionY: Double, val motionZ: Double){}
}