package pl.damian.producer.domain;

public interface EventPublisher<E extends InternalEvent> {
    void send(final E event);
}
