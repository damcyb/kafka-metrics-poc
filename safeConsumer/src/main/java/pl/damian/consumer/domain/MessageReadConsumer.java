package pl.damian.consumer.domain;


import pl.damian.data.model.MessageEvent;

public interface MessageReadConsumer {

    void consume(final MessageEvent event);
}
