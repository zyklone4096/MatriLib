package cn.afternode.matrilib.core.nms.mcp

import cn.afternode.matrilib.core.MotionData
import cn.afternode.matrilib.core.nms.base.IPacketWrapper
import cn.afternode.matrilib.core.utils.Maths
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import org.bukkit.entity.Entity

class MCPPacketWrapper: IPacketWrapper {
    override fun asMotionData(packet: Any, entity: Entity): MotionData {
        val className = packet::class.java.name
        val clazz = packet::class.java
        val pdsClass = Class.forName("net.minecraft.network.PacketDataSerializer")
        if (className.startsWith("net.minecraft.network.protocol.game")) {
            val allocate = clazz.getDeclaredMethod("a", pdsClass)
            if (!allocate.isAccessible) allocate.isAccessible = true
            val pds = createPacketDataSerializer()
            allocate.invoke(pds)
            val readDouble = pdsClass.getDeclaredMethod("readDouble")
            val loc = entity.location
            return MotionData(
                Maths.positive(readDouble.invoke(pds) as Double - loc.x),
                Maths.positive(readDouble.invoke(pds) as Double - loc.y),
                Maths.positive(readDouble.invoke(pds) as Double - loc.z), entity.location, entity.isOnGround)
        } else {
            throw IllegalArgumentException("Except NMS packet")
        }
    }

    override fun createPacketDataSerializer(): Any {
        val clazz = Class.forName("net.minecraft.network.PacketDataSerializer")
        val constructor = clazz.getDeclaredConstructor(ByteBuf::class.java)
        if (!constructor.isAccessible) constructor.isAccessible = true
        return constructor.newInstance(ByteBufAllocator.DEFAULT.buffer())
    }
}