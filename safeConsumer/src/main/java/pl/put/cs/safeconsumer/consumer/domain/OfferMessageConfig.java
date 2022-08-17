package pl.put.cs.safeconsumer.consumer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferMessageConfig {

    @Bean
    public OfferMessageConsumer offerMessageFacade(final OfferMessageRepository offerMessageRepository) {
        return new OfferMessageFacade(offerMessageRepository);
    }
}
