package cn.afternode.matrilib.core.nms.legacy

import cn.afternode.matrilib.core.nms.NMSProvider
import cn.afternode.matrilib.core.nms.base.IPacketWrapper
import cn.afternode.matrilib.core.nms.base.IProvider

/**
 * The NMSProvider for versions before 1.17
 */
class LegacyProvider: IProvider {
    private val packetWrapper: LegacyPacketWrapper = LegacyPacketWrapper()

    override fun getType(): NMSProvider.NMSType {
        return NMSProvider.NMSType.LEGACY
    }

    override fun getPacketWrapper(): IPacketWrapper {
        return packetWrapper
    }
}