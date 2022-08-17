package pl.put.cs.safeconsumer.consumer.infrastructure;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.put.cs.safeconsumer.consumer.domain.OfferMessage;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Configuration
class OfferMessageCacheConfig {

    private final String OFFER_MESSAGE_CACHE_NAME = "replicatedMessageReadCache";
    private final long CACHE_EXPIRATION_TIME_IN_DAYS = 14;

    @Bean
    Map<UUID, OfferMessage> offerMessageCache(EmbeddedCacheManager manager, ConfigurationBuilder cb) {
        cb.expiration().maxIdle(CACHE_EXPIRATION_TIME_IN_DAYS, TimeUnit.DAYS);
        org.infinispan.configuration.cache.Configuration c = cb.build();
        manager.defineConfiguration(OFFER_MESSAGE_CACHE_NAME, c);
        return manager.getCache(OFFER_MESSAGE_CACHE_NAME);
    }
}