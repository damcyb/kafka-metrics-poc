package pl.damian.consumer;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.damian.consumer.domain.OfferMessageConsumer;
import pl.damian.data.model.MessageEvent;

import java.time.Duration;
import java.time.Instant;

import static lombok.AccessLevel.PRIVATE;
import static pl.damian.consumer.infrastructure.OfferMessageConst.Groups.MESSAGE_READ_GROUP;
import static pl.damian.consumer.infrastructure.OfferMessageConst.Listeners.MESSAGE_READ_LISTENER_CONTAINER_FACTORY;
import static pl.damian.consumer.infrastructure.OfferMessageConst.Topics.MESSAGE_READ_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Component
class MessageListener {

    OfferMessageConsumer offerMessageConsumer;
    @NonFinal Long counter = 0L;
    Long limit = 200_000L;
    @NonFinal Instant startTime;


    @KafkaListener(topics = {MESSAGE_READ_EVENTS, "case_1_config_13"}, groupId = MESSAGE_READ_GROUP, containerFactory = MESSAGE_READ_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(MessageEvent event) {


        if (counter.equals(0L)) {
            log.info("[READ MESSAGE] message {}", event.toString());
            startTime = Instant.now();
        }
        offerMessageConsumer.consume(event);
        counter++;
        if (counter.equals(limit)) {
            System.out.println("Elapsed time: " + Duration.between(startTime, Instant.now()).toMillis());
            counter = 0L;
        }
    }
}
