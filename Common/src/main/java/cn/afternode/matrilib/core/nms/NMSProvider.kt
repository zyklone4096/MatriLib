package cn.afternode.matrilib.core.nms

import cn.afternode.matrilib.core.nms.base.IProvider
import cn.afternode.matrilib.core.nms.legacy.LegacyProvider
import org.bukkit.Bukkit
import java.util.logging.Logger

object NMSProvider {
    val logger: Logger = Logger.getLogger("MatriLib-NMS")

    lateinit var provider: IProvider

    @JvmStatic
    fun getObcVersion(): String {
        return Bukkit.getServer()::class.java.name.split(".")[3]
    }

    enum class NMSType {
        LEGACY, MCP
    }

    fun setup() {
        val version = Bukkit.getServer()::class.java.name.split(".")[3]
        val major = Integer.parseInt(version.split("_")[1])
        logger.info("Detected OBC version $version (Major $major)")
        if (major < 17) {
            logger.info("Using Legacy NMS")
            provider = LegacyProvider()
        } else {
            logger.info("Using MCP NMS")
        }
    }
}