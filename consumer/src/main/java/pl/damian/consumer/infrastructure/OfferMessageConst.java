package pl.damian.consumer.infrastructure;

public interface OfferMessageConst {

    interface Listeners {
        String MESSAGE_READ_LISTENER_CONTAINER_FACTORY = "concurrentKafkaListenerContainerFactory";
    }

    interface Groups {
        String MESSAGE_READ_GROUP = "${app.kafka.group-id}";
    }

    interface Topics {
//        String MESSAGE_READ_EVENTS = "test-topic-100";
        String MESSAGE_READ_EVENTS = "case_1_config_1";
    }
}