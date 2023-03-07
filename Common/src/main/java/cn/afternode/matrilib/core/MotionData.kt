package cn.afternode.matrilib.core

import org.bukkit.Location

data class MotionData(
    val motionX: Double = 0.0, val motionY: Double = 0.0, val motionZ: Double = 0.0, val baseLoc: Location,
    val onGround: Boolean = true)
