package br.com.lanchonete.usecase;


import br.com.lanchonete.exception.ClientNotInformedException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveClientUsecaseTests {

    @InjectMocks
    private SaveClientUsecase saveClient;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ValidateClientUsecase validateClient;
    @Mock
    private LogRepository logRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void saveClientSuccess() throws Exception {
        Client client = easyRandom.nextObject(Client.class);
        when(clientRepository.save(client)).thenReturn(client);

        Client clientSaved = saveClient.save(client);

        assertThat(clientSaved).isNotNull();
        assertThat(clientSaved.getCpf()).isEqualTo(client.getCpf());
        assertThat(clientSaved.getName()).isEqualTo(client.getName());
        assertThat(clientSaved.getEmail()).isEqualTo(client.getEmail());
        verify(validateClient, atLeast(1)).validate(client);
        verify(clientRepository, atLeast(1)).save(client);
    }

    @Test
    public void saveClientWithErrorNullClient() throws Exception {
        doThrow(new ClientNotInformedException()).when(validateClient).validate(null);

        assertThatThrownBy(() -> saveClient.save(null))
                .isInstanceOf(ClientNotInformedException.class)
                .hasMessage("Cliente não informado");
    }

}
