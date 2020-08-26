package ap.demo.com.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class SpringDemoApplication {
    private static ApplicationContext appCtx;

	public static void main(String[] args) {
		appCtx = SpringApplication.run(SpringDemoApplication.class, args);
        checkPresence("FeignClientExample");
	}

    private static void checkPresence(String... beans) {
        System.out.println("Checking beans");
        for (String bean : beans) {
            if (appCtx.containsBean(bean)) {
                System.out.println(bean);
            }
        }
    }

}
