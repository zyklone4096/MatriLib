package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrilib.core.MotionData
import cn.afternode.matrilib.core.utils.Locations
import org.bukkit.entity.Entity
import kotlin.math.roundToInt
import kotlin.math.sin

/**
 * This module must be created for an Entity
 */
class SpeedModule(val entity: Entity) {
    var aac4BHopLegitHop = false
    fun calcAAC4BHop(isMoving: Boolean = true): Array<MotionData> {
        val data = ArrayList<MotionData>()

        if (isMoving) {
            if (aac4BHopLegitHop) {
                if (entity.isOnGround) {
                    data.add(MotionData(baseLoc = entity.location))
                    aac4BHopLegitHop = false
                }
            }
            if (entity.isOnGround) {
                val strafe = Movement.calculateStrafe(entity.location, 0.375f, 0.0F)
                data.add(MotionData(motionX = strafe[0].toDouble(), motionZ = strafe[1].toDouble(), baseLoc = entity.location))
            }
        } else {
            data.add(MotionData(baseLoc = entity.location))
            aac4BHopLegitHop = true
        }

        return data.toTypedArray()
    }

    fun calcAacBHop(isMoving: Boolean = false): Array<MotionData> {
        val data = ArrayList<MotionData>()

        if (isMoving) {
            if (entity.isOnGround) {
                val f = entity.location.yaw * 0.017453292f
                val mot = MotionData((sin(f)*0.2f).toDouble(), 0.399, (sin(f)*0.2f).toDouble(), entity.location)
                data.add(mot)
            }
        } else {
            data.add(MotionData(baseLoc = entity.location))
        }

        return data.toTypedArray()
    }
}