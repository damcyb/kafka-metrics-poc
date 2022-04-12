package pl.damian.producer.infrastructure;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaAsyncEventPublisher implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplate;

    @Override
    public void send(InternalEvent event) {
        try {
            final var producerRecord = new ProducerRecord<>(MESSAGE_READ_EVENTS, event.getKey(), event);
            kafkaTemplate.send(producerRecord);
            log.info("Message was sent");
        } catch (KafkaException exception) {
            log.error("Error while sending async event to Kafka cluster", exception);
        }
    }
}
