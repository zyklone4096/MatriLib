package cn.afternode.matrilib.core.nms.base

import cn.afternode.matrilib.core.nms.NMSProvider

interface IProvider {
    fun getType(): NMSProvider.NMSType
    fun getPacketWrapper(): IPacketWrapper
}