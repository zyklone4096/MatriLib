package cn.afternode.matrlib

import cn.afternode.matrlib.utils.GitUtil
import org.bukkit.plugin.java.JavaPlugin

class MatrLib: JavaPlugin() {
    companion object {
        @JvmStatic
        val PLATFORMS = 3

        @JvmStatic
        val IN_DEV = false
    }

    lateinit var version: String

    override fun onEnable() {
        version = description.version
        if (IN_DEV) {
            val build = GitUtil.getBuildData()
            version = "${build.version}(${build.username}) git-${build.commit}"
        }

        logger.info("+===========MatrLib===========+")
        logger.info(" Version: $version")
        logger.info(" Platforms: $PLATFORMS")
        logger.info(" This plugin should not do anything")
        logger.info("+=============================+")
    }
}