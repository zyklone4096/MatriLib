package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrlib.liquidbounce.LiquidColors.stripColor
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

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

    /**
     * Try to generate a bot entity to bypass the default settings
     */
    @JvmStatic
    fun generateBot(loc: Location, name: String, invisible: Boolean = true): Player {
        val entity = loc.world.spawnEntity(loc, EntityType.PLAYER) as Player
        entity.setGravity(false)
        if (invisible) entity.addPotionEffect(PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 255, false, false))
        entity.customName = name
        entity.playerListName = name
        entity.displayName = name
        entity.gameMode = GameMode.SURVIVAL
        return entity
    }
}