package net.hk.netty.self.nettybegin.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Administrator on 2018/7/8.
 */
public class TimeClient {

    public static void main(String[] args){

        String host = "127.0.0.1";
        int port = 8080;
//
//        NioEventLoopGroup workderGroup = new NioEventLoopGroup();
//
//        Bootstrap bootstrap = new Bootstrap();
//        bootstrap.group(workderGroup)
//                .channel(NioSocketChannel.class)
//                .option(ChannelOption.SO_KEEPALIVE,true)
//                .handler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new TimeServerHandler());
//                    }
//                });
//
//        try {
//            ChannelFuture channelFuture = bootstrap.connect().sync();
//            channelFuture.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            workderGroup.shutdownGracefully();
//        }



//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeClientHandler());
                }
            });

            try {
                // 启动客户端
                ChannelFuture f = b.connect(host, port).sync();
                // 等待连接关闭
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } finally {
            workerGroup.shutdownGracefully();
        }

    }

}
