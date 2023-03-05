package cn.afternode.matrlib.liquidbounce

import java.util.regex.Pattern

object LiquidColors {
    private val COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]")

    @JvmStatic
    fun stripColor(input: String?): String? {
        return COLOR_PATTERN.matcher(input ?: return null).replaceAll("")
    }
}