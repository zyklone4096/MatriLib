package cn.afternode.matrilib.enjoythebans

import cn.afternode.matrilib.core.BlockPos.Companion.asBlockPos
import cn.afternode.matrilib.core.MotionData
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Entity

object AntiVoid {
    @JvmStatic
    fun calc(entity: Entity): MotionData {
        var blockUnderneath = false
        var i = 0
        while (i.toDouble() < entity.location.y + 2.0) {
            val pos = entity.location.asBlockPos()
            if (entity.location.world.getBlockAt(entity.location).type != Material.AIR) {
                blockUnderneath = true
            }
            ++i
        }
        if (blockUnderneath) {
            return MotionData(baseLoc = entity.location)
        }
        if (!entity.isOnGround) {
            return MotionData(motionY = 0.07, baseLoc = entity.location)
        }
        return MotionData(baseLoc = entity.location)
    }
}