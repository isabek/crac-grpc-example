package com.itashiev.crac.grpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(name = "grpc.enabled", havingValue = "true", matchIfMissing = true)
public class GrpcServerAutoConfiguration {

    @Bean
    public GrpcServerCheckpointLifecycle grpcServerCheckpointLifecycle(final GrpcServerFactory factory) {
        return new GrpcServerCheckpointLifecycle(factory);
    }

    @Bean
    public NettyGrpcServerFactory nettyGrpcServerFactory() {
        return new NettyGrpcServerFactory();
    }
}
