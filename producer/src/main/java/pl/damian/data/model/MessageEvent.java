package pl.damian.data.model;

import lombok.Value;
import model.offer.OfferDto;
import pl.damian.producer.domain.InternalEvent;
import static java.util.Objects.requireNonNull;

import java.util.UUID;

@Value
public class MessageEvent implements InternalEvent {

    UUID eventId;
    UUID offerId;
    String title;
    Double price;
    String currency;

    public static MessageEvent convertFromOfferDto(final OfferDto dto) {
        requireNonNull(dto.getId());
        return new MessageEvent(
                UUID.randomUUID(),
                dto.getId(),
                dto.getTitle(),
                dto.getPrice(),
                dto.getCurrency());
    }

    @Override
    public String getKey() {
        return offerId.toString();
    }
}
