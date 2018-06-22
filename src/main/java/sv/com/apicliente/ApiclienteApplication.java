package sv.com.apicliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"sv.com.apicliente"})
public class ApiclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiclienteApplication.class, args);
	}
}
