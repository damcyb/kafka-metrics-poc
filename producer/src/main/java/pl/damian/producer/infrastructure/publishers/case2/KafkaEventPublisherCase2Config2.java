package pl.damian.producer.infrastructure.publishers.case2;

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
import java.util.concurrent.ExecutionException;

import static pl.damian.producer.infrastructure.OfferMessageConst.Topics.case_2_config_2;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaEventPublisherCase2Config2 implements EventPublisher<InternalEvent> {

    KafkaTemplate<String, InternalEvent> kafkaTemplateCase2Config2;

    @Override
    public void send(InternalEvent event) {
        BigInteger number = new BigInteger("10000000");
        try {
            Instant start = Instant.now();

            for (int i = 0; i < number.intValue(); i++) {
                final var producerRecord = new ProducerRecord<>(case_2_config_2, event.getKey(), event);
                final var sendResult = kafkaTemplateCase2Config2.send(producerRecord);
                kafkaTemplateCase2Config2.flush();
                sendResult.get();
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            log.info("Time Elapsed in ms: " + timeElapsed);
//            log.info("Send " + number.divide(new BigInteger(String.valueOf(timeElapsed))).multiply(new BigInteger("1000")) + " messages per second");
            log.info("Message was sent CASE2CONFIG2");
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sending interrupted", e);
        } catch (KafkaException | ExecutionException exception) {
            log.error("Error while sending async event to Kafka cluster", exception);
        }
    }
}