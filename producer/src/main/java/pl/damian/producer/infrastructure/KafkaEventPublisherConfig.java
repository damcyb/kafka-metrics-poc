package pl.damian.producer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;
import pl.damian.producer.infrastructure.publishers.case1.*;

@Configuration
public class KafkaEventPublisherConfig {

    //test
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

    @Bean
    EventPublisher kafkaEventPublisherCase1Config2(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config2) {
        return new KafkaEventPublisherCase1Config2(kafkaTemplateCase1Config2);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config3(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config3) {
        return new KafkaEventPublisherCase1Config3(kafkaTemplateCase1Config3);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config4(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config4) {
        return new KafkaEventPublisherCase1Config4(kafkaTemplateCase1Config4);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config5(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config5) {
        return new KafkaEventPublisherCase1Config5(kafkaTemplateCase1Config5);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config6(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config6) {
        return new KafkaEventPublisherCase1Config6(kafkaTemplateCase1Config6);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config7(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config7) {
        return new KafkaEventPublisherCase1Config7(kafkaTemplateCase1Config7);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config8(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config8) {
        return new KafkaEventPublisherCase1Config8(kafkaTemplateCase1Config8);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config9(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config9) {
        return new KafkaEventPublisherCase1Config9(kafkaTemplateCase1Config9);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config10(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config10) {
        return new KafkaEventPublisherCase1Config10(kafkaTemplateCase1Config10);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config11(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config11) {
        return new KafkaEventPublisherCase1Config11(kafkaTemplateCase1Config11);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config12(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config12) {
        return new KafkaEventPublisherCase1Config12(kafkaTemplateCase1Config12);
    }
    @Bean
    EventPublisher kafkaEventPublisherCase1Config13(final KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config13) {
        return new KafkaEventPublisherCase1Config13(kafkaTemplateCase1Config13);
    }
}
