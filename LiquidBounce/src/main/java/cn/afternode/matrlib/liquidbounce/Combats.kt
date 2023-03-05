package cn.afternode.matrlib.liquidbounce

import org.bukkit.Location

object Combats {
    enum class CriticalType {
        // LiquidBounce
        Packet, NCPPacket, TPHop
    }

    /**
     * This module of LiquidBounce may send multi packets
     * @return An array of calculated locations
     */
    @JvmStatic
    fun calculateCriticalLocations(origin: Location, type: CriticalType): Array<Location> {
        val list = ArrayList<Location>()
        var tmp = origin

        when (type.name) {
            "Packet" -> {
                tmp = Location(origin.world, origin.x, origin.y+0.0625, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+1.1E-5, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)

            }
            "NCPPacket" -> {
                tmp = Location(origin.world, origin.x, origin.y+0.11, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.1100013579, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.0000013579, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
            }
            "TPHop" -> {
                tmp = Location(origin.world, origin.x, origin.y+0.02, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.01, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.01, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
            }
            else -> {
                throw IllegalArgumentException("Unknown critical type")
            }
        }

        return list.toTypedArray()
    }
}