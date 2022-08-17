package pl.put.cs.safeconsumer.consumer.infrastructure;

public interface OfferMessageConst {

    interface Listeners {
        String MESSAGE_READ_LISTENER_CONTAINER_FACTORY = "concurrentKafkaListenerContainerFactory";
        String DLT_MESSAGE_READ_LISTENER_CONTAINER_FACTORY = "dltConcurrentKafkaListenerContainerFactory";
    }

    interface Groups {
        String MESSAGE_READ_GROUP = "${app.kafka.group-id}";
    }

    interface Topics {
        String MESSAGE_READ_EVENTS = "test-topic-100";
    }
}
