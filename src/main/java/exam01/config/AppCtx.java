package exam01.config;

import exam01.Great;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class AppCtx {
    @Bean
    public Great great() {
        return new Great();
    }
}
