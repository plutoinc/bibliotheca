package network.pluto.bibliotheca.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("network.pluto.bibliotheca.configurations")
@EnableJpaRepositories("network.pluto.bibliotheca.repositories")
@EntityScan("network.pluto.bibliotheca.models")
public class BibliothecaConfiguration {

}
