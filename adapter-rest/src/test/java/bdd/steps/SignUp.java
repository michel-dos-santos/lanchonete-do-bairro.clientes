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

public class SignUp extends SpringIntegrationTest {

    private String nameValue;
    private String cpfValue;
    private String emailValue;
    private String passwordValue;

    public SignUp(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    @Given("que o cliente informa os dados de name={string}, cpf={string}, email={string}, password={string}")
    public void insertInputIntoClient(String nameValue, String cpfValue, String emailValue, String passwordValue) {
        this.nameValue = nameValue;
        this.cpfValue = cpfValue;
        this.emailValue = emailValue;
        this.passwordValue = passwordValue;
    }

    @And("envia a requisição de cadastro para url={string}")
    public void sendRequest(String url) throws IOException, JSONException {
        JSONObject json = new JSONObject()
                .accumulate("name", this.nameValue)
                .accumulate("cpf", this.cpfValue)
                .accumulate("email", this.emailValue)
                .accumulate("password", this.passwordValue);

        executePost(url, json.toString());
    }

    @Then("a requisição retornará o status code {int} indicando inconsistência no cadastro")
    public void statusCode(int statusCode) {
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(statusCode);
    }

    @And("com o response com a mensagem={string} do cadastro")
    public void messageError(String message) throws IOException {
        assertTrue(responseEntity.getBody().toString().contains(message));
    }

}
