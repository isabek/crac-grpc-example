package com.itashiev.crac.grpc;

import io.grpc.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServerCheckpointLifecycle implements SmartLifecycle {
    private static final Logger log = LoggerFactory.getLogger(GrpcServerCheckpointLifecycle.class);

    private static final int SHUTDOWN_GRACE_PERIOD = 5;

    private final GrpcServerFactory grpcServerFactory;
    private Server server;

    public GrpcServerCheckpointLifecycle(GrpcServerFactory grpcServerFactory) {
        this.grpcServerFactory = grpcServerFactory;
    }

    @Override
    public void start() {
        try {
            createAndStartGrpcServer();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to start gRPC server", e);
        }
    }

    @Override
    public void stop() {
        stopAndReleaseGrpcServer();
    }

    @Override
    public boolean isRunning() {
        return server != null && !server.isShutdown();
    }

    private void createAndStartGrpcServer() throws IOException {
        if (this.server == null) {
            final Server localServer = this.grpcServerFactory.createServer();
            final int port = this.grpcServerFactory.getPort();
            this.server = localServer;
            localServer.start();
            log.info("gRPC server started on port: {}", port);

            final Thread awaitTermination = new Thread(() -> {
                try {
                    server.awaitTermination();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            awaitTermination.setName("grpc-server-awaiter");
            awaitTermination.setDaemon(false);
            awaitTermination.start();
        }
    }

    private void stopAndReleaseGrpcServer() {
        final Server localServer = this.server;
        if (localServer != null) {
            log.info("Initiating gRPC server shutdown");
            localServer.shutdown();

            try {
                localServer.awaitTermination(SHUTDOWN_GRACE_PERIOD, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                server.shutdownNow();
                this.server = null;
            }
            log.info("Completed gRPC server shutdown");
        }
    }
}
