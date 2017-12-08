package distributed_applications.reviewapi;

import ReviewDatabase.InMemoryDatabase;
import ReviewDatabase.ReviewDatabaseInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author redro
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableDiscoveryClient
public class Application {
   
    public static void main(String[] args) throws Exception{
        new SpringApplication(Application.class).run(args);
    }
    
    @Bean
    public ReviewDatabaseInterface reviewDatabaseInterface(){
        return new InMemoryDatabase();
    }
}
