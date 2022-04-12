package pl.damian.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class MessageEvent {

    @JsonCreator
    public MessageEvent(
        @JsonProperty("eventId") UUID eventId,
        @JsonProperty("offerId") UUID offerId,
        @JsonProperty("title") String title,
        @JsonProperty("price") Double price,
        @JsonProperty("currency") String currency
    ) {

        requireNonNull(eventId);
        requireNonNull(offerId);

        this.eventId = eventId;
        this.offerId = offerId;
        this.title = title;
        this.price = price;
        this.currency = currency;
    }

    UUID eventId;
    UUID offerId;
    String title;
    Double price;
    String currency;

}
