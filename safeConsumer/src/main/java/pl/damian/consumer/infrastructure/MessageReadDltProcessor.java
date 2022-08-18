package pl.damian.consumer.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static org.springframework.kafka.support.KafkaHeaders.EXCEPTION_MESSAGE;

@Slf4j
@Component
class MessageReadDltProcessor {

    public void processDltMessage(ConsumerRecord<String, Object> message,
                                  @Header(EXCEPTION_MESSAGE) String exceptionMessage) {
        log.error("[DLT PROCESSOR]");
        log.error("topic: {}", message.topic());
        log.error("partition: {}", message.partition());
        log.error("offset: {}", message.offset());
        log.error("key: {}", message.key());
        log.error("value: {}", message.value());
        log.error("exceptionMessage: {}", exceptionMessage);
    }
}
