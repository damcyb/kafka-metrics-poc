package pl.damian.producer.infrastructure.publishers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.case_1_config_3;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaEventPublisherCase1Config3 implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config3;

    @Override
    public void send(InternalEvent event) {
        try {
            final var producerRecord = new ProducerRecord<>(case_1_config_3, event.getKey(), event);
            kafkaTemplateCase1Config3.send(producerRecord);
            log.info("Message was sent CASE1CONFIG3");
        } catch (KafkaException exception) {
            log.error("Error while sending async event to Kafka cluster", exception);
        }
    }
}