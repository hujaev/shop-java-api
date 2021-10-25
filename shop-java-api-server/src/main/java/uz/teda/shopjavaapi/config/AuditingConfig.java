package uz.teda.shopjavaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.teda.shopjavaapi.entity.User;

import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {
    @Bean
    public AuditorAware<Integer> auditorAware() {
        return new SpringSecurityAuditAwareImpl();
    }
}

class SpringSecurityAuditAwareImpl implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if (!(authentication == null || !authentication.isAuthenticated()
               || "anonymousUser".equals("" + authentication.getPrincipal()))) {
           return Optional.of(((User) authentication.getPrincipal()).getId());
       }
       return Optional.empty();
   }
}

