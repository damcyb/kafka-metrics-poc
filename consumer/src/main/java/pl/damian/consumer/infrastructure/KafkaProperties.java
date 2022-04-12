package pl.damian.consumer.infrastructure;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "app.kafka")
@Configuration
@Getter
@Setter
class KafkaProperties {

    String groupId;
    String bootstrapServers;
}