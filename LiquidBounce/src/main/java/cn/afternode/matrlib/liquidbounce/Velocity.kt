package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrilib.core.MotionData
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

    fun calculateVelocity(type: VelocityType, e: Entity): Array<MotionData> {
        val list = ArrayList<MotionData>()

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

    private fun calculateLBVelocity(type: VelocityType, e: Entity): List<MotionData> {
        val list = ArrayList<MotionData>()

        when (type.name) {
            "Jump" -> {
                val yaw = e.location.yaw * 0.017453292F
                list.add(MotionData(sin(yaw) * 0.2, 0.0, cos(yaw) * 0.2, e.location))

            }

        }

        return list
    }

    private fun calculatePrideVelocity(type: VelocityType, e: Entity): List<MotionData> {
        val list = ArrayList<MotionData>()

        when (type.name) {
            "Feile" -> {
                if (e.isOnGround) {
                    list.add(MotionData(1.5, 1.2, 1.5, e.location))
                } else {
                    list.add(MotionData(0.0,0.0,0.0, e.location))
                }
            }
        }

        return list
    }
}