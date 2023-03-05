package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrlib.liquidbounce.LiquidColors.stripColor
import org.bukkit.entity.Entity
import org.bukkit.entity.Player

object AntiBot {
    /**
     * ALL with default configuration values
     */
    @JvmStatic
    fun isBot(entity: Entity, from: Player? = null): Boolean {
        // Check if entity is a player
        if (entity !is Player)
            return false

        // Anti Bot checks

        if ((entity.entityId >= 1000000000 || entity.entityId <= -1))
            return true

        if (entity.location.pitch > 90F || entity.location.pitch < -90F)
            return true

        val targetName = stripColor(entity.displayName)

        if (targetName != null) {
            return true
        }

        var fromName = ""
        if (from != null) fromName = from.name

        return entity.name.isEmpty() || entity.name == fromName
    }
}