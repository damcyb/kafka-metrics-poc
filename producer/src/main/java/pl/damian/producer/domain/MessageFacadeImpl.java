package pl.damian.producer.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import model.offer.OfferDto;
import pl.damian.data.model.MessageEvent;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageFacadeImpl implements MessageFacade {

    List<EventPublisher> eventPublishers;

    @Override
    public void sendEvent(final OfferDto offerDto) {
        final var event = MessageEvent.convertFromOfferDto(offerDto);
        eventPublishers.forEach(eventPublisher -> eventPublisher.send(event));
    }
}
