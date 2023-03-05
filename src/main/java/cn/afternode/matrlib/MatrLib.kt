package cn.afternode.matrlib

import org.bukkit.plugin.java.JavaPlugin

class MatrLib: JavaPlugin() {
    companion object {
        @JvmStatic
        val PLATFORMS = 1
    }

    lateinit var version: String

    override fun onEnable() {
        version = description.version

        logger.info("+===========MatrLib===========+")
        logger.info(" Version: $version")
        logger.info(" Platforms: $PLATFORMS")
        logger.info(" This plugin should not do anything")
        logger.info("+=============================+")
    }
}