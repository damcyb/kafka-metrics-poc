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

import java.time.Duration;
import java.time.Instant;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaAsyncEventPublisher implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplate;

    @Override
    public void send(InternalEvent event) {

        int number = 1000;
        try {
            Instant start = Instant.now();

            for (int i = 0; i < number; i++) {
                final var producerRecord = new ProducerRecord<>(MESSAGE_READ_EVENTS, event.getKey(), event);
                kafkaTemplate.send(producerRecord);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            log.info("Time Elapsed in ms: " + timeElapsed);
            log.info("Send " + number / timeElapsed * 1000 + " messages per second");
            log.info("Message was sent");
        } catch (KafkaException exception) {
            log.error("Error while sending async event to Kafka cluster", exception);
        }
    }
}
