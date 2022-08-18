package pl.damian.consumer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.damian.consumer.domain.MessageRead;
import pl.damian.consumer.domain.MessageReadRepository;

import java.util.Map;
import java.util.UUID;

@Configuration
class MessageReadRepositoryConfig {

    @Bean
    public MessageReadRepository messageReadRepository(Map<UUID, MessageRead> messagesRead) {
        return new MessageReadInMemoryRepository(messagesRead);
    }

//    @Bean
//    public MessageReadRepository messageReadRepository() {
//        return new InMemoryMessageReadRepository(new ConcurrentHashMap<>());
//    }
}
