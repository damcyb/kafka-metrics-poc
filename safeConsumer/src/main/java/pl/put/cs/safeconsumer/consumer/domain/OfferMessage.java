package pl.put.cs.safeconsumer.consumer.domain;

import lombok.Value;
import pl.put.cs.safeconsumer.consumer.model.MessageEvent;


import java.io.Serializable;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class OfferMessage implements Serializable {

    UUID eventId;
    UUID offerId;
    String title;
    Double price;
    String currency;

    public static OfferMessage fromMessageEvent(final MessageEvent event) {
        requireNonNull(event.getEventId());
        requireNonNull(event.getOfferId());

        return new OfferMessage(
                event.getEventId(),
                event.getOfferId(),
                event.getTitle(),
                event.getPrice(),
                event.getCurrency()
        );
    }
}
