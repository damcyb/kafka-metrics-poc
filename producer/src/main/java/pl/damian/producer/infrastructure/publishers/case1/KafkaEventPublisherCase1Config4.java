package pl.damian.producer.infrastructure.publishers.case1;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.EventPublisher;
import pl.damian.producer.domain.InternalEvent;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.case_1_config_4;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaEventPublisherCase1Config4 implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config4;

    @Override
    public void send(InternalEvent event) {
        BigInteger number = new BigInteger("500000");
        try {
            Instant start = Instant.now();

            for (int i = 0; i < number.intValue(); i++) {
                final var producerRecord = new ProducerRecord<>(case_1_config_4, event.getKey(), event);
                kafkaTemplateCase1Config4.send(producerRecord);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            log.info("Time Elapsed in ms: " + timeElapsed);
            log.info("Message was sent CASE1CONFIG4");
        } catch (KafkaException exception) {
            log.error("Error while sending async event to Kafka cluster", exception);
        }
    }
}