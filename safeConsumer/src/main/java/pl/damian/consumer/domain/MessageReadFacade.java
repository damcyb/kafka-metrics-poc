package pl.damian.consumer.domain;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import pl.damian.data.model.MessageEvent;

import javax.transaction.Transactional;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class MessageReadFacade implements MessageReadConsumer {

    MessageReadRepository messageReadRepository;

    @Transactional
    @Override
    public void consume(MessageEvent event) {
        final var messageRead = MessageRead.fromMessageEvent(event);

        if (hasEventBeenAlreadyProcessed(messageRead)) {
//            log.info("Message has been already processed: {}", event.getEventId());
            return;
        }

        processMessage(messageRead);
        messageReadRepository.save(messageRead);
    }

    private void processMessage(final MessageRead messageRead) {
//        if (messageRead.getInteractionType().equals("error")) {
//            throw new RuntimeException("Simulate error");
//        }
        log.info("Message safely processed!");
    }

    private boolean hasEventBeenAlreadyProcessed(final MessageRead messageRead) {
        return messageReadRepository.exists(messageRead.getEventId());
    }
}
