package dev.boong.blog.config.jpa;

import dev.boong.blog.domain.member.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {


    @Bean
    public AuditorAware<String> auditorAware() {
        // TODO: 2022-09-22 스프링 시큐리티 인증 기능 도입 후 수정
        return () -> Optional.of("test");
    }
}
