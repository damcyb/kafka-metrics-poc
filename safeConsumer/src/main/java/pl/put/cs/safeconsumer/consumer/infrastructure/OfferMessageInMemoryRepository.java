package pl.put.cs.safeconsumer.consumer.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.put.cs.safeconsumer.consumer.domain.OfferMessage;
import pl.put.cs.safeconsumer.consumer.domain.OfferMessageRepository;

import java.util.Map;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
class OfferMessageInMemoryRepository implements OfferMessageRepository {

    Map<UUID, OfferMessage> offerMessages;

    @Override
    public boolean exists(UUID eventId) {
        return offerMessages.keySet()
                .stream()
                .anyMatch(x -> x.equals(eventId));
    }

    @Override
    public void save(OfferMessage messageRead) {
        offerMessages.put(messageRead.getEventId(), messageRead);
    }
}