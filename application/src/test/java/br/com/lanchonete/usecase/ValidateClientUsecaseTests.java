package br.com.lanchonete.usecase;


import br.com.lanchonete.exception.ClientInvalidException;
import br.com.lanchonete.exception.ClientNotInformedException;
import br.com.lanchonete.model.Client;
import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.port.repository.LogRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ValidateClientUsecaseTests {

    @InjectMocks
    private ValidateClientUsecase validateClient;
    @Mock
    private LogRepository logRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void validateSuccess() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        client.setCpf("16741677097");

        validateClient.validate(client);

        verify(logRepository, atLeast(1)).info(ValidateClientUsecase.class, LogCode.LogCodeInfo._0002);
    }

    @Test
    public void validateWithErrorNullClient() throws Exception {
        assertThatThrownBy(() -> validateClient.validate(null))
                .isInstanceOf(ClientNotInformedException.class)
                .hasMessage("Cliente não informado");
    }

    @Test
    public void validateWithErrorCPFInvalid() throws Exception {
        Client client = easyRandom.nextObject(Client.class);

        assertThatThrownBy(() -> validateClient.validate(client))
                .isInstanceOf(ClientInvalidException.class)
                .hasMessage(String.format("Cliente inválido com base no %s: %s", "cpf", client.getCpf()));
    }

    @Test
    public void validateWithErrorNullName() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        client.setCpf("16741677097");
        client.setName(null);

        assertThatThrownBy(() -> validateClient.validate(client))
                .isInstanceOf(ClientInvalidException.class)
                .hasMessage(String.format("Cliente inválido com base no %s: %s", "name", client.getName()));
    }

    @Test
    public void validateWithErrorEmptyName() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        client.setCpf("16741677097");
        client.setName("");

        assertThatThrownBy(() -> validateClient.validate(client))
                .isInstanceOf(ClientInvalidException.class)
                .hasMessage(String.format("Cliente inválido com base no %s: %s", "name", client.getName()));
    }

    @Test
    public void validateWithErrorNullEmail() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        client.setCpf("16741677097");
        client.setEmail(null);

        assertThatThrownBy(() -> validateClient.validate(client))
                .isInstanceOf(ClientInvalidException.class)
                .hasMessage(String.format("Cliente inválido com base no %s: %s", "email", client.getEmail()));
    }

    @Test
    public void validateWithErrorEmptyEmail() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        client.setCpf("16741677097");
        client.setEmail("");

        assertThatThrownBy(() -> validateClient.validate(client))
                .isInstanceOf(ClientInvalidException.class)
                .hasMessage(String.format("Cliente inválido com base no %s: %s", "email", client.getEmail()));
    }
    
}
