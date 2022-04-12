package pl.damian.consumer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferMessageConfig {

    @Bean
    public OfferMessageConsumer offerMessageFacade() {
        return new OfferMessageFacade();
    }
}
