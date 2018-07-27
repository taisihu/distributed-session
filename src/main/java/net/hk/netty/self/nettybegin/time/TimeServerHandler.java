package net.hk.netty.self.nettybegin.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Administrator on 2018/7/8.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 连接被建立并且准备进行通信时被调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {

        final ByteBuf time = ctx.alloc().buffer(4);

        time.writeInt((int)(System.currentTimeMillis()/1000L + 2208988800L));

        /**
         * ChannelFuture 代表了一个还没有发生的 I/O 操作,
         * 这意味着任何一个请求操作都不会马上被执行，
         * 因为在 Netty 里所有的操作都是异步的
         */
        final ChannelFuture channelFuture = ctx.writeAndFlush(time);

        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {

                assert channelFuture == future;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
