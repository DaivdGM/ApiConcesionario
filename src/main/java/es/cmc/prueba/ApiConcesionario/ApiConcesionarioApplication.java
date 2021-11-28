package es.cmc.prueba.ApiConcesionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@ComponentScan("es")
@EnableJpaRepositories("es.cmc.ApiConcesionario.repository")
public class ApiConcesionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiConcesionarioApplication.class, args);
	}

}
