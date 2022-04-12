package pl.damian.consumer;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.damian.consumer.domain.OfferMessageConsumer;
import pl.damian.data.model.MessageEvent;

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

    @KafkaListener(topics = MESSAGE_READ_EVENTS, groupId = MESSAGE_READ_GROUP, containerFactory = MESSAGE_READ_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(MessageEvent event) {

        log.info("[READ MESSAGE] message {}", event.toString());
        offerMessageConsumer.consume(event);
    }
}
