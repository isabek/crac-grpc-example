package com.itashiev.crac.grpc;

import io.grpc.Server;

public interface GrpcServerFactory {
    int DEFAULT_GRPC_SERVER_PORT = 6565;

    Server createServer();

    default int getPort() {
        return DEFAULT_GRPC_SERVER_PORT;
    }
}
