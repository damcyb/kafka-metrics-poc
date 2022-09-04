package pl.damian.producer.infrastructure.configs.case1;

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
public class KafkaProducerConfigurationCase1Config9 extends AbstractKafkaProducerConfigurationCaseConfig {

    public KafkaProducerConfigurationCase1Config9(KafkaProperties kafkaProperties) {
        super(kafkaProperties);
    }

    @Override
    @Bean("kafkaTemplateCase1Config9")
    public KafkaTemplate<String, InternalEvent> kafkaTemplateCase1Config() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(getProducerConfig()));
    }

    protected final Map<String, Object> getProducerConfig() {
        final Map<String, Object> properties = getDefaultProducerConfig();
        properties.putAll(kafkaProperties.getSettingsForCase_1Config_9());

        return properties;
    }

}