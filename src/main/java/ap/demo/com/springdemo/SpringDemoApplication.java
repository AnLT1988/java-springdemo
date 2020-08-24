package ap.demo.com.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import ap.demo.com.springdemo.api.FeignClientExample;
import ap.demo.com.springdemo.model.Post;

@SpringBootApplication
@EnableFeignClients
@ComponentScan
@RestController
public class SpringDemoApplication {
    private static ApplicationContext appCtx;

    @Autowired
    private FeignClientExample feignClient;

    @GetMapping("all_posts")
    public List<Post> getPosts() {
        System.out.println("Doing a feign");
        return feignClient.getAllPosts();
    }

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
