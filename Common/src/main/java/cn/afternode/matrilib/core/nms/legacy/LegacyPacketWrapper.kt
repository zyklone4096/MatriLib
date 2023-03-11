package cn.afternode.matrilib.core.nms.legacy

import cn.afternode.matrilib.core.MotionData
import cn.afternode.matrilib.core.nms.NMSProvider
import cn.afternode.matrilib.core.nms.base.IPacketWrapper
import cn.afternode.matrilib.core.utils.Maths
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import org.bukkit.entity.Entity
import org.omg.CORBA.Object

class LegacyPacketWrapper: IPacketWrapper {
    override fun asMotionData(packet: Any, entity: Entity): MotionData {
        val className = packet::class.java.name
        val clazz = packet::class.java
        val pdsClass = Class.forName("net.minecraft.server.${NMSProvider.getObcVersion()}.PacketDataSerializer")
        if (className.startsWith("net.minecraft.server.v_")) {
            if (className.endsWith("PacketPlayInPosition") || className.equals("PacketPlayInPositionLook")) {
                val buf = createPacketDataSerializer()
                val method = clazz.getDeclaredMethod("b", pdsClass)
                if (!method.isAccessible) method.isAccessible = true
                method.invoke(packet, buf)

                val readDouble = pdsClass.getDeclaredMethod("readDouble")
                if (!readDouble.isAccessible) readDouble.isAccessible = true
                val loc = entity.location
                return MotionData(
                    Maths.positive(readDouble.invoke(buf) as Double - loc.x),
                    Maths.positive(readDouble.invoke(buf) as Double - loc.y),
                    Maths.positive(readDouble.invoke(buf) as Double - loc.z), entity.location, entity.isOnGround)
            } else {
                throw IllegalArgumentException("Except PacketPlayInPosition or PacketPlayInPositionLook")
            }
        } else {
            throw IllegalArgumentException("Except NMS object")
        }
    }

    override fun createPacketDataSerializer(): Any {
        val clazz = Class.forName("net.minecraft.server.${NMSProvider.getObcVersion()}.PacketDataSerializer")
        val constructor = clazz.getDeclaredConstructor(ByteBuf::class.java)
        if (!constructor.isAccessible) constructor.isAccessible = true
        return constructor.newInstance(ByteBufAllocator.DEFAULT.buffer())
    }
}