package pl.put.cs.safeconsumer.consumer.domain;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import pl.put.cs.safeconsumer.consumer.model.MessageEvent;

import javax.transaction.Transactional;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class OfferMessageFacade implements OfferMessageConsumer {

    OfferMessageRepository offerMessageRepository;

    @Transactional
    @Override
    public void consume(MessageEvent event) {
        final var messageRead = OfferMessage.fromMessageEvent(event);

        if (hasEventBeenAlreadyProcessed(messageRead)) {
            log.info("Message has been already processed: {}", event.getEventId());
            return;
        }

        processMessage(messageRead);
        offerMessageRepository.save(messageRead);
    }

    private void processMessage(final OfferMessage messageRead) {
//        if (messageRead.getInteractionType().equals("error")) {
//            throw new RuntimeException("Simulate error");
//        }
        //processing message
    }

    private boolean hasEventBeenAlreadyProcessed(final OfferMessage messageRead) {
        return offerMessageRepository.exists(messageRead.getEventId());
    }
}
