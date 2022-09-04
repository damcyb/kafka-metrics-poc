package pl.damian.producer.infrastructure.configs.case2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import pl.damian.producer.domain.InternalEvent;
import pl.damian.producer.infrastructure.KafkaProperties;
import pl.damian.producer.infrastructure.configs.AbstractKafkaProducerConfigurationCaseConfig;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfigurationCase2Config1 extends AbstractKafkaProducerConfigurationCaseConfig {

    public KafkaProducerConfigurationCase2Config1(KafkaProperties kafkaProperties) {
        super(kafkaProperties);
    }

    @Override
    @Bean("kafkaTemplateCase2Config1")
    public KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(getProducerConfig()));
    }

    @Override
    protected final Map<String, Object> getProducerConfig() {
        final Map<String, Object> properties = getDefaultProducerConfig();
        properties.putAll(kafkaProperties.getSettingsForCase_2Config_1());

        return properties;
    }

}
