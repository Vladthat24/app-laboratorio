package gob.ogti.laboratorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LaboratorioApplication extends SpringBootServletInitializer{

	/*public static void main(String[] args) {
		SpringApplication.run(LavoratorioApplication.class, args);
	}*/
	
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(LaboratorioApplication.class);
	}

	public static void main(String[] args) {
		
		SpringApplication application =  new  SpringApplication (LaboratorioApplication.class);
				
		application.run(args);
	}

}
