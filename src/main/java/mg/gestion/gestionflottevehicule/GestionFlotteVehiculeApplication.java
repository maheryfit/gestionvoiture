package mg.gestion.gestionflottevehicule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class GestionFlotteVehiculeApplication {

	private static final Logger logger = LoggerFactory.getLogger(GestionFlotteVehiculeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GestionFlotteVehiculeApplication.class, args);
	}

}
