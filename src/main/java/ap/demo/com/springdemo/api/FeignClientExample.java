package ap.demo.com.springdemo.api;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ap.demo.com.springdemo.model.Post;

@FeignClient(url="https://jsonplaceholder.typicode.com", name="POST-FEIGN")
public interface FeignClientExample {
    
    @GetMapping("posts")
    public List<Post> getAllPosts();
}
