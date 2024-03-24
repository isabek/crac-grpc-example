package com.itashiev.crac.grpc;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

public class NettyGrpcServerFactory implements GrpcServerFactory {
    @Override
    public Server createServer() {
        return NettyServerBuilder.forPort(getPort()).build();
    }
}
