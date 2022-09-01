package pl.damian;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(MeterRegistry registry) {
        return args -> {
            registry.getMeters().forEach(meter -> System.out.println(meter.getId()));
        };
    }
}
