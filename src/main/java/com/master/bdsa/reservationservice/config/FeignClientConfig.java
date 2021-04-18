package com.master.bdsa.reservationservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jt on 5/16/20.
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor( @Value("${mvs.vacation-user}") String vacationUser,
                                                                    @Value("${mvs.vacation-password}")String vacationPassword){
        return new BasicAuthRequestInterceptor(vacationUser, vacationPassword);
    }
}
