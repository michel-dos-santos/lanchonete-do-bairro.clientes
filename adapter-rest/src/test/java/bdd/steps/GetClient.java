package bdd.steps;

import bdd.config.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetClient extends SpringIntegrationTest {

    private UUID idValue;

    public GetClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    @Given("que o sistema informa o identificador={string} do cliente")
    public void insertInputIntoClient(String idValue) {
        this.idValue = UUID.fromString(idValue);
    }

    @And("envia a requisição para url={string}")
    public void sendRequestSignIn(String url) throws IOException {
        executeGet(url+this.idValue);
    }

    @Then("a requisição retornará o status code {int}")
    public void statusCode(int statusCode) {
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(statusCode);
    }

    @And("com o response contendo o identificador={string}")
    public void messageError(String message) throws IOException {
        assertTrue(responseEntity.getBody().toString().contains(message));
    }

}