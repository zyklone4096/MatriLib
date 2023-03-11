package cn.afternode.matrilib.core.nms.mcp

import cn.afternode.matrilib.core.nms.NMSProvider
import cn.afternode.matrilib.core.nms.base.IPacketWrapper
import cn.afternode.matrilib.core.nms.base.IProvider

/**
 * The NMSProvider for versions 1.17 and newer
 */
class MCPProvider: IProvider {
    private val packetWrapper = MCPPacketWrapper()

    override fun getType(): NMSProvider.NMSType {
        return NMSProvider.NMSType.MCP
    }

    override fun getPacketWrapper(): IPacketWrapper {
        return packetWrapper
    }
}