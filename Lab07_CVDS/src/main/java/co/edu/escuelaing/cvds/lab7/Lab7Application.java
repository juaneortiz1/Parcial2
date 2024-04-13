package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.model.UserRole;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Lab7Application {
	private final ConfigurationService configurationService;
	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;

	@Autowired
	public Lab7Application(
			ConfigurationService configurationService,
			UserRepository userRepository,
			EmployeeRepository employeeRepository
	) {
		this.configurationService = configurationService;
		this.userRepository = userRepository;
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			log.info("Adding Configurations....");
			configurationService.addConfiguration(new Configuration("premio", "810000"));
			configurationService.addConfiguration(new Configuration("descuento", "0.1"));
			configurationService.addConfiguration(new Configuration("app-name", "Miraculous: Las Aventuras de Ladybug"));

			log.info("\nGetting all configurations....");
			configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));

			log.info("\nAdding admin@site.org user with Password: admin");
			userRepository.save(new User("admin@site.org", "admin", Arrays.asList(UserRole.ADMINISTRADOR, UserRole.CLIENTE)));
			/*funciona desde back
			log.info("\nAdding a new employee....");
			Employee newEmployee = new Employee();
			newEmployee.setEmployeeId("123");
			newEmployee.setFirstName("John");
			newEmployee.setLastName("Doe");
			newEmployee.setRole("Developer");
			newEmployee.setSalary(50000.0);
			employeeRepository.save(newEmployee);
			funciona desde back*/
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
