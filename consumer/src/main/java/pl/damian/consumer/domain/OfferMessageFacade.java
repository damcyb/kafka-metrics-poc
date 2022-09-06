package pl.damian.consumer.domain;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import pl.damian.data.model.MessageEvent;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class OfferMessageFacade implements OfferMessageConsumer {

    @Override
    public void consume(MessageEvent event) {
//        final var offerMessage = OfferMessage.fromMessageEvent(event);
//        processMessage(offerMessage);
    }

    private void processMessage(final OfferMessage offerMessage) {
        log.info("Message processed :)");
    }
}
