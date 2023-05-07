package edu.ifrs.conhecimentoatravesvideos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "edu.ifrs.conhecimentoatravesvideos.repositorios")
@ComponentScan(basePackages = { "edu.ifrs.conhecimentoatravesvideos" })
@EnableTransactionManagement
@EntityScan(basePackages = "edu.ifrs.conhecimentoatravesvideos.model")
@SpringBootApplication
public class ConhecimentoAtravesVideosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConhecimentoAtravesVideosApplication.class, args);
	}

}
