package pl.damian.consumer.infrastructure;

public interface MessageReadConst {

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
