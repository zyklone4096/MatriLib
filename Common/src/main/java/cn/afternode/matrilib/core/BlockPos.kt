package cn.afternode.matrilib.core

import org.bukkit.Location
import org.bukkit.World

data class BlockPos(val world: World, val x: Double, val y: Double, val z: Double) {
    companion object {
        @JvmStatic
        fun Location.asBlockPos(): BlockPos {
            return BlockPos(world, x, y, z)
        }
    }
}