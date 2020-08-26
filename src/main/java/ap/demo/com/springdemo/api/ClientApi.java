package ap.demo.com.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ap.demo.com.springdemo.model.Post;

@RestController
public class ClientApi {
    
    @Autowired
    private FeignClientExample feignClient;

    @GetMapping("all_posts")
    public List<Post> getAllPosts() {
        return feignClient.getAllPosts();
    }
}
