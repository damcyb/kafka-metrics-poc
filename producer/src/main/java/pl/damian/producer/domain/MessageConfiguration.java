package pl.damian.producer.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MessageConfiguration {

    @Bean
    public MessageFacadeImpl messageFacade(
            @Qualifier("kafkaAsyncEventPublisher")
            final EventPublisher eventPublisher,
            @Qualifier("kafkaEventPublisherCase1Config1")
            final EventPublisher kafkaEventPublisherCase1Config1
    ) {
        return new MessageFacadeImpl(Arrays.asList(eventPublisher, kafkaEventPublisherCase1Config1));
    }
}
