package ThirdPartyAPI.consume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private RestTemplate restTemplate;

    String baseURL = "http://localhost:8085/api/";  //"https://jsonplaceholder.typicode.com/";
    String GET  = "/getAll";
    String GETBYID = "/getAll/";
    String CREATE = "/createCompany";
    StringBuilder stringBuilder = new StringBuilder(baseURL);
    @Override
    public List<Map<String, Object>> getAllPosts() {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = stringBuilder.append(GET).toString();
        var response =  restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
   return response.getBody();
    }

    @Override
    public Map<String, Object> getById(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
        String url = stringBuilder.append(GETBYID).append(id).toString();
        var response =  restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> create(Map<String, Object> payload) {
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, gethttpHeaders());
        String url = stringBuilder.append(CREATE).toString();
        var response =  restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        return response.getBody();
    }

    private HttpHeaders gethttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
