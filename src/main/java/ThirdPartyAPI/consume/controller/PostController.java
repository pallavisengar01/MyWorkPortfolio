package ThirdPartyAPI.consume.controller;

import ThirdPartyAPI.consume.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/consume")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/getPostAll")
    List<Map<String, Object>> getPosts(){
     return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    Map<String, Object> getById(@PathVariable int id){
        return postService.getById(id);
    }

    @PostMapping("/createAll")
    Map<String, Object> createAll(@RequestBody Map<String,Object> payload) {
        return postService.create(payload);
    }
}
