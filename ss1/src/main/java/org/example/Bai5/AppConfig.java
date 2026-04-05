package org.example.Bai5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SystemConfig systemConfig() {
        return new SystemConfig("Cyber Center Hoan Kiem", "08:00 AM");
    }
}
