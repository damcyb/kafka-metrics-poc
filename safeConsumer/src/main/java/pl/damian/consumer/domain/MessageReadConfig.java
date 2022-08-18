package pl.damian.consumer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MessageReadConfig {

    @Bean
    public MessageReadConsumer messageReadFacade(final MessageReadRepository messageReadRepository) {
        return new MessageReadFacade(messageReadRepository);
    }
}
