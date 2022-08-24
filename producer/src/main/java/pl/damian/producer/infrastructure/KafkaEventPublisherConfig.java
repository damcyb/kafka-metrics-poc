package pl.damian.producer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;
import pl.damian.producer.infrastructure.publishers.KafkaEventPublisherCase1Config1;

@Configuration
public class KafkaEventPublisherConfig {

    @Bean
    EventPublisher kafkaAsyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaAsyncEventPublisher(kafkaTemplate);
    }

    @Bean
    EventPublisher kafkaSyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaSyncEventPublisher(kafkaTemplate);
    }

    @Bean
    EventPublisher kafkaEventPublisherCase1Config1(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config1) {
        return new KafkaEventPublisherCase1Config1(kafkaTemplateCase1Config1);
    }
}
