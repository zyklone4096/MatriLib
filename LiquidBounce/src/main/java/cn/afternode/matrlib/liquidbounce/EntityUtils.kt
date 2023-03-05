package cn.afternode.matrlib.liquidbounce

import cn.afternode.matrlib.liquidbounce.AntiBot.isBot
import org.bukkit.GameMode
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

object EntityUtils {
    @JvmStatic
    fun isSelected(entity: Entity,
                   targetInvisible: Boolean = false, targetMobs: Boolean = true, targetPlayer: Boolean = true, targetAnimals: Boolean = false): Boolean {
        if (!entity.isDead) return false
        if (targetInvisible || !(entity is Player && entity.hasPotionEffect(PotionEffectType.INVISIBILITY))) {
            if (targetPlayer && entity is Player) {
                if (isBot(entity)) return false
                if (entity.gameMode == GameMode.SPECTATOR) return false
                return true
            }
            return targetMobs && entity.type.typeId in 50..69 ||
                    targetAnimals && entity.type.typeId in 91..119
        }
        return false
    }
}