package bdd.config;

import br.com.lanchonete.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {

    protected RestTemplate restTemplate;
    protected ResponseEntity<?> responseEntity;
    @Autowired
    protected ModelMapper modelMapper;
    @Autowired
    protected ObjectMapper objectMapper;;


    @Autowired
    public SpringIntegrationTest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    public void executeGet(String url) throws IOException {
        responseEntity = restTemplate.getForEntity(url, String.class);
    }

    public void executePost(String url, String jsonString) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(jsonString, headers);
        responseEntity = restTemplate.postForEntity(url, entity, Object.class);
    }
}