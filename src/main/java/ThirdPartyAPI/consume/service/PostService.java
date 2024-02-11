package ThirdPartyAPI.consume.service;

import java.util.List;
import java.util.Map;

public interface PostService {

    List<Map<String, Object>> getAllPosts();
    Map<String, Object> getById(int id);
    Map<String,Object> create(Map<String, Object> payload);
}
