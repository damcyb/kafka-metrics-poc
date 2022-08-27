package pl.damian.producer.infrastructure.configs;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pl.damian.producer.domain.InternalEvent;
import pl.damian.producer.infrastructure.KafkaProperties;

import java.util.HashMap;
import java.util.Map;

import static lombok.AccessLevel.PROTECTED;

@RequiredArgsConstructor
@FieldDefaults(level = PROTECTED, makeFinal = true)
public abstract class AbstractKafkaProducerConfigurationCaseConfig {

    KafkaProperties kafkaProperties;

    public abstract KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config();

    protected abstract Map<String, Object> getProducerConfig();

    protected final Map<String, Object> getDefaultProducerConfig() {
        final Map<String, Object> properties = new HashMap<>();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(ProducerConfig.RETRIES_CONFIG, 1);
        properties.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, "5000");
        properties.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "5000");

        return properties;
    }

}
