package pl.damian.producer.infrastructure;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "app.kafka")
@Configuration
@Getter
@Setter
public class KafkaProperties {

    String bootstrapServers;

    Map<String, Object> getFastProducerSettings() {
        final Map<String, Object> properties = new HashMap<>();

        /* below fast producer settings, additionally use fire-and-forget producer type */
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 2);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 32_768);
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33_554_432);
        properties.put(ProducerConfig.ACKS_CONFIG, "0");

        return properties;
    }
}
