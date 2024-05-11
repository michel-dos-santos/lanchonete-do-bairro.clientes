package bdd.steps;

import bdd.config.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignIn extends SpringIntegrationTest {

    private String usernameValue;
    private String passwordValue;

    public SignIn(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    @Given("que o cliente informa os dados de username={string}, password={string}")
    public void insertInputIntoClient(String usernameValue, String passwordValue) {
        this.usernameValue = usernameValue;
        this.passwordValue = passwordValue;
    }

    @And("envia a requisição de login para url={string}")
    public void sendRequestSignIn(String url) throws IOException, JSONException {
        JSONObject json = new JSONObject()
                .accumulate("username", this.usernameValue)
                .accumulate("password", this.passwordValue);

        executePost(url, json.toString());
    }

    @Then("a requisição retornará o status code {int} indicando inconsistência no login")
    public void statusCode(int statusCode) {
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(statusCode);
    }

    @And("com o response com a mensagem={string} do login")
    public void messageError(String message) throws IOException {
        assertTrue(responseEntity.getBody().toString().contains(message));
    }

}
