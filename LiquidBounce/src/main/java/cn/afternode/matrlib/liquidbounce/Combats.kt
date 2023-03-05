package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrlib.liquidbounce.other.DreamMore
import org.bukkit.Location

object Combats {
    enum class CriticalType {
        // LiquidBounce
        Packet, NCPPacket, TPHop,

        // DreamMore
        DMDuel, DMVulcan, DMStarPacket
    }

    /**
     * This module of LiquidBounce may send multi packets
     * @param look An configuration for some modes
     * @return An array of calculated locations
     */
    @JvmStatic
    fun calculateCriticalLocations(origin: Location, type: CriticalType, look: Boolean = false): Array<Location> {
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
            "DMDuel" -> {
                tmp = Location(origin.world, origin.x, origin.y+0.6251314, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.0181314, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.0011314, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(tmp.world, tmp.x, tmp.y+0.001314, tmp.z, tmp.yaw, tmp.pitch)
                list.add(tmp)
            }
            "DMVulcan" -> {
                tmp = Location(origin.world, origin.x, origin.y+5.11322554E-4, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(origin.world, origin.x, origin.y+1.1119999543618E-4, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
                tmp = Location(origin.world, origin.x, origin.y+6.221E-5, origin.z, origin.yaw, origin.pitch)
                list.add(tmp)
            }
            "DMStarPacket" -> {
                list.add(DreamMore.calculateCriticalLocation(0.0, 6.6666E-6, 0.0, false, 5, origin, look))
                list.add(DreamMore.calculateCriticalLocation(0.0, 7.8E-7, 0.0, false, 5, origin, look))
                list.add(DreamMore.calculateCriticalLocation(0.0, 1.14514E-6, 0.0, false, 5, origin, look))
                list.add(DreamMore.calculateCriticalLocation(0.0, 0.0, 0.0, false, 7, origin, look))
            }
            else -> {
                throw IllegalArgumentException("Unknown critical type")
            }
        }

        return list.toTypedArray()
    }


}