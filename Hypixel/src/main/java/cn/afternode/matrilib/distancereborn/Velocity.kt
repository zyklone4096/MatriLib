package cn.afternode.matrilib.distancereborn

import cn.afternode.matrilib.core.AbstractModule
import cn.afternode.matrilib.core.MotionData
import org.bukkit.entity.Entity

class Velocity(e: Entity) : AbstractModule(e) {
    var velocityTick = 0
    var needSimple = false
    private var velocityInput = false

    fun calcTickVelocity(tick: Int): Array<MotionData> {
        val arr = ArrayList<MotionData>()
        if (tick>velocityTick) {
            arr.add(MotionData(0.0, 0.0, 0.0, e.location))
            velocityInput = false
        }
        if (e.isOnGround && velocityTick>1) {
            velocityInput = false
        }
        return arr.toTypedArray()
    }
}