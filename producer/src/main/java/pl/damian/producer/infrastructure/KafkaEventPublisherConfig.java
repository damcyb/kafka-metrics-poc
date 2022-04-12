package pl.damian.producer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;

@Configuration
public class KafkaEventPublisherConfig {

    @Bean
    EventPublisher kafkaAsyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaAsyncEventPublisher(kafkaTemplate);
    }
}
