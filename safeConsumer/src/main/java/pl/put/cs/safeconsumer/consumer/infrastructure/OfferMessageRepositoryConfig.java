package pl.put.cs.safeconsumer.consumer.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.put.cs.safeconsumer.consumer.domain.OfferMessage;
import pl.put.cs.safeconsumer.consumer.domain.OfferMessageRepository;

import java.util.Map;
import java.util.UUID;

@Configuration
class OfferMessageRepositoryConfig {

    @Bean
    public OfferMessageRepository offerMessageRepository(Map<UUID, OfferMessage> offerMessageCache) {
        return new OfferMessageInMemoryRepository(offerMessageCache);
    }

//    @Bean
//    public MessageReadRepository messageReadRepository() {
//        return new InMemoryMessageReadRepository(new ConcurrentHashMap<>());
//    }
}
