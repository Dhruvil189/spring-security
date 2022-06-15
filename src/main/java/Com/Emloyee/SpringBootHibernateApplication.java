package Com.Emloyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



//@SpringBootApplication
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
public class SpringBootHibernateApplication extends SpringBootServletInitializer
{
		public static void main(String[] args) throws Exception {  //main method
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}
}
