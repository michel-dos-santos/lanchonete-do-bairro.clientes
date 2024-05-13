package br.com.lanchonete.postgres;

import br.com.lanchonete.exception.ClientFoundException;
import br.com.lanchonete.exception.ClientNotFoundException;
import br.com.lanchonete.model.Client;
import br.com.lanchonete.postgres.repository.PostgresDBClientRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={br.com.lanchonete.postgres.TestApplication.class})
public class PostgresDBClientRepositoryTests {

    @Autowired
    private PostgresDBClientRepository clientRepository;

    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void saveTest() throws Exception {
        Client clientInput = easyRandom.nextObject(Client.class);
        clientInput.setId(null);
        clientInput.setCpf("10902661035");

        Client clientOutput = clientRepository.save(clientInput);
        Optional<Client> optionalClientByCPF = Optional.of(clientRepository.identifierByCPF(clientOutput.getCpf()));
        assertThat(optionalClientByCPF).isPresent();

        Optional<Client> optionalClientByID = Optional.of(clientRepository.identifierById(clientOutput.getId()));
        assertThat(optionalClientByID).isPresent();
    }

    @Test
    public void saveExistsClientTest() throws Exception {
        Client clientInput = easyRandom.nextObject(Client.class);
        clientInput.setId(null);
        clientInput.setCpf("10902661036");

        Client clientOutput = clientRepository.save(clientInput);
        Optional<Client> optionalClientByCPF = Optional.of(clientRepository.identifierByCPF(clientOutput.getCpf()));
        assertThat(optionalClientByCPF).isPresent();

        Client clientExists = easyRandom.nextObject(Client.class);
        clientExists.setId(null);
        clientExists.setCpf(clientOutput.getCpf());

        assertThatThrownBy(() -> clientRepository.save(clientExists))
                .isInstanceOf(ClientFoundException.class)
                .hasMessage(String.format("Cliente já existente com base no %s: %s", "cpf", clientExists.getCpf()));

    }

    @Test
    public void identifierByCPFNotExistsClientTest() throws Exception {
        Client clientInput = easyRandom.nextObject(Client.class);
        clientInput.setId(null);
        clientInput.setCpf("10902661037");

        assertThatThrownBy(() -> clientRepository.identifierByCPF(clientInput.getCpf()))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("Cliente não encontrado com base no %s: %s", "cpf", clientInput.getCpf()));

    }

    @Test
    public void identifierByIDNotExistsClientTest() throws Exception {
        Client clientInput = easyRandom.nextObject(Client.class);
        clientInput.setId(UUID.randomUUID());
        clientInput.setCpf("10902661038");

        assertThatThrownBy(() -> clientRepository.identifierById(clientInput.getId()))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("Cliente não encontrado com base no %s: %s", "id", clientInput.getId()));

    }

}
