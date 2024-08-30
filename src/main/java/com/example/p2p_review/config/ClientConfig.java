package com.example.p2p_review.config;

import com.example.p2p_review.client.SpecialistProfileClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

//    @Bean
//    SpecialistProfileClient specialistProfileClient() {
//        WebClient webClient = WebClient.builder()
//                .baseUrl("http://localhost:8081")
//                .build();
//        WebClientAdapter adapter = WebClientAdapter.create(webClient);
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
//        return factory.createClient(SpecialistProfileClient.class);
//    }
}

