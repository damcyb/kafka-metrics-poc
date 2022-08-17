package pl.put.cs.safeconsumer.consumer.domain;

import pl.put.cs.safeconsumer.consumer.model.MessageEvent;

public interface OfferMessageConsumer {

    void consume(final MessageEvent event);
}
