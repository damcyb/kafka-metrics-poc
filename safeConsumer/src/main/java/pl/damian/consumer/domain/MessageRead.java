package pl.damian.consumer.domain;

import lombok.Value;
import pl.damian.data.model.MessageEvent;

import java.io.Serializable;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class MessageRead implements Serializable {

    UUID eventId;
    UUID offerId;
    String title;
    Double price;
    String currency;

    public static MessageRead fromMessageEvent(final MessageEvent event) {
        requireNonNull(event.getEventId());
        requireNonNull(event.getOfferId());

        return new MessageRead(
                event.getEventId(),
                event.getOfferId(),
                event.getTitle(),
                event.getPrice(),
                event.getCurrency()
        );
    }
}
