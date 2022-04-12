package pl.damian.producer.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import model.offer.OfferDto;
import pl.damian.data.model.MessageEvent;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageFacade {

    EventPublisher eventPublisher;

    public void sendEvent(final OfferDto offerDto) {
        final var event = MessageEvent.convertFromOfferDto(offerDto);
        eventPublisher.send(event);
    }
}
