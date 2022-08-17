package pl.put.cs.safeconsumer.consumer.domain;

import java.util.UUID;

public interface OfferMessageRepository {
    boolean exists(final UUID eventId);
    void save(final OfferMessage offerMessage);
}
