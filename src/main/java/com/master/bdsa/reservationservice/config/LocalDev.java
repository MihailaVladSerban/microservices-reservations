package com.master.bdsa.reservationservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-dev")
@EnableDiscoveryClient
@Configuration
public class LocalDev {
}
