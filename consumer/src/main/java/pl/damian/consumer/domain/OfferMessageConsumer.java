package pl.damian.consumer.domain;

import pl.damian.data.model.MessageEvent;

public interface OfferMessageConsumer {

    void consume(final MessageEvent event);
}
