package net.hk.netty.self.nettybegin.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 *
 * 丢弃数据handler
 *
 * Created by Administrator on 2018/7/7.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();

                ctx.write(msg); // (1)
                ctx.flush(); // (2)
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
