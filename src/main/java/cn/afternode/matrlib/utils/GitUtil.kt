package cn.afternode.matrlib.utils

import cn.afternode.matrlib.MatrLib
import java.util.*

object GitUtil {
    val gitInfo = Properties().also {
        val inputStream = MatrLib::class.java.classLoader.getResourceAsStream("git.properties")

        if(inputStream != null) {
            it.load(inputStream)
        } else {
            it["git.build.version"] = "unofficial"
        }
    }

    fun getBuildData(): BuildData {
        return BuildData(
            gitInfo["git.build.version"] as String,
            gitInfo["git.commit.id.abbrev"] as String,
            gitInfo["git.build.user.name"] as String
        )
    }

    data class BuildData(val version: String, val commit: String, val username: String)
}