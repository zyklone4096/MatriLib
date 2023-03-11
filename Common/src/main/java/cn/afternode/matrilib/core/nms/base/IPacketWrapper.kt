package cn.afternode.matrilib.core.nms.base

import cn.afternode.matrilib.core.MotionData
import org.bukkit.entity.Entity
import org.omg.CORBA.Object

interface IPacketWrapper {
    /**
     * Converts Position, Look and PositionLook packets into MotionData
     */
    fun asMotionData(packet: Any, entity: Entity): MotionData
    fun createPacketDataSerializer(): Any
}