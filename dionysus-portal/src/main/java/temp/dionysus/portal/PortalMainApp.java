package temp.dionysus.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
//@ComponentScan("temp.dionysus.customer.service")
public class PortalMainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DatabaseConfig.class);
		//		ctx.register(WebViewConfig.class);
		SpringApplication.run(PortalMainApp.class, args);
	}
}
