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
            final EventPublisher kafkaEventPublisherCase1Config1,
            @Qualifier("kafkaEventPublisherCase1Config2")
            final EventPublisher kafkaEventPublisherCase1Config2,
            @Qualifier("kafkaEventPublisherCase1Config3")
            final EventPublisher kafkaEventPublisherCase1Config3,
            @Qualifier("kafkaEventPublisherCase1Config4")
            final EventPublisher kafkaEventPublisherCase1Config4,
            @Qualifier("kafkaEventPublisherCase1Config5")
            final EventPublisher kafkaEventPublisherCase1Config5,
            @Qualifier("kafkaEventPublisherCase1Config6")
            final EventPublisher kafkaEventPublisherCase1Config6,
            @Qualifier("kafkaEventPublisherCase1Config7")
            final EventPublisher kafkaEventPublisherCase1Config7,
            @Qualifier("kafkaEventPublisherCase1Config8")
            final EventPublisher kafkaEventPublisherCase1Config8,
            @Qualifier("kafkaEventPublisherCase1Config9")
            final EventPublisher kafkaEventPublisherCase1Config9,
            @Qualifier("kafkaEventPublisherCase2Config1")
            final EventPublisher kafkaEventPublisherCase2Config1
    ) {
        return new MessageFacadeImpl(Arrays.asList(
//                eventPublisher,
//                kafkaEventPublisherCase1Config1,
//                kafkaEventPublisherCase1Config2,
//                kafkaEventPublisherCase1Config3,
//                kafkaEventPublisherCase1Config4,
//                kafkaEventPublisherCase1Config5,
//                kafkaEventPublisherCase1Config6,
//                kafkaEventPublisherCase1Config7,
//                kafkaEventPublisherCase1Config8,
//                kafkaEventPublisherCase1Config9
        kafkaEventPublisherCase2Config1
        ));
    }
}
