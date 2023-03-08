package cn.afternode.matrilib.core

abstract class AbstractPlatform {
    abstract val name: String
    abstract val version: String
    abstract val originalAuthor: String
    abstract val description: String?
}