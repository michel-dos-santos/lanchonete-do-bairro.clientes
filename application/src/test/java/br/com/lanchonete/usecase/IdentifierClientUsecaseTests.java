package br.com.lanchonete.usecase;


import br.com.lanchonete.exception.ClientNotFoundException;
import br.com.lanchonete.model.Client;
import br.com.lanchonete.port.repository.ClientRepository;
import br.com.lanchonete.port.repository.LogRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IdentifierClientUsecaseTests {

    @InjectMocks
    private IdentifierClientUsecase identifierClient;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private LogRepository logRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void identifierClientByCPFFound() throws Exception {
        String cpf = easyRandom.nextObject(String.class);
        Client client = easyRandom.nextObject(Client.class);
        when(clientRepository.identifierByCPF(cpf)).thenReturn(client);

        Client clientFound = identifierClient.identifierByCPF(cpf);

        assertThat(clientFound).isNotNull();
        assertThat(clientFound).isEqualTo(client);
        verify(clientRepository, atLeast(1)).identifierByCPF(cpf);
    }

    @Test
    public void identifierClientByCPFNotFound() throws Exception {
        String cpf = easyRandom.nextObject(String.class);
        when(clientRepository.identifierByCPF(cpf)).thenThrow(new ClientNotFoundException("cpf", cpf));

        assertThatThrownBy(() -> identifierClient.identifierByCPF(cpf))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("Cliente não encontrado com base no %s: %s", "cpf", cpf));
    }

    @Test
    public void identifierClientByIDFound() throws Exception {
        UUID id = easyRandom.nextObject(UUID.class);
        Client client = easyRandom.nextObject(Client.class);
        when(clientRepository.identifierById(id)).thenReturn(client);

        Client clientFound = identifierClient.identifierById(id);

        assertThat(clientFound).isNotNull();
        assertThat(clientFound).isEqualTo(client);
        verify(clientRepository, atLeast(1)).identifierById(id);
    }

    @Test
    public void identifierClientByIDNotFound() throws Exception {
        UUID id = easyRandom.nextObject(UUID.class);
        when(clientRepository.identifierById(id)).thenThrow(new ClientNotFoundException("id", id.toString()));

        assertThatThrownBy(() -> identifierClient.identifierById(id))
                .isInstanceOf(ClientNotFoundException.class)
                .hasMessage(String.format("Cliente não encontrado com base no %s: %s", "id", id));
    }
}
