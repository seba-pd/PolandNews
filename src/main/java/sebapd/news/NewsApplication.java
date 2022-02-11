package sebapd.news;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NewsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args).close();
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private final Service service;

    public NewsApplication(@Lazy Service service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.getPolandNews();
    }
}
