package pl.damian.consumer;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import pl.damian.data.model.MessageEvent;
import pl.damian.consumer.domain.MessageReadConsumer;
import pl.damian.consumer.infrastructure.MessageReadConst;

import java.time.Duration;
import java.time.Instant;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Component
class MessageListener {

    MessageReadConsumer messageReadConsumer;

    @NonFinal
    Long counter = 0L;
    Long limit = 100L;
    @NonFinal Instant startTime;

    @KafkaListener(topics = {MessageReadConst.Topics.MESSAGE_READ_EVENTS, "case_1_config_13"},
            groupId = MessageReadConst.Groups.MESSAGE_READ_GROUP,
            containerFactory = MessageReadConst.Listeners.MESSAGE_READ_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(MessageEvent event,
                              @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                              @Header(KafkaHeaders.OFFSET) Long offset,
                              Acknowledgment ack) {

//        log.info("[READ MESSAGE] topic: {}, partition: {}, offset: {}, message: {}", topic, partition, offset, event.toString());
//        messageReadConsumer.consume(event);
//        ack.acknowledge();

        if (counter.equals(0L)) {
            log.info("[READ MESSAGE] message {}", event.toString());
            startTime = Instant.now();
        }
        messageReadConsumer.consume(event);
        counter++;
        ack.acknowledge();
        if (counter.equals(limit)) {
            System.out.println("Elapsed time: " + Duration.between(startTime, Instant.now()).toMillis());
            counter = 0L;
        }

    }
}