package pl.damian.producer.infrastructure;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;

import java.util.concurrent.ExecutionException;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaSyncEventPublisher implements EventPublisher {

    KafkaTemplate<String, InternalEvent> kafkaTemplate;

    @Override
    public void send(InternalEvent event) {
        try {
            final var producerRecord = new ProducerRecord<>(MESSAGE_READ_EVENTS, event.getKey(), event);
            final var sendResult = kafkaTemplate.send(producerRecord);
            kafkaTemplate.flush();
            sendResult.get();
            log.info("Send message");
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sending interrupted", e);
        } catch (final KafkaException | ExecutionException e) {
            log.error("There was error while synchronous send event to Kafka cluster", e);
        }
    }
}
