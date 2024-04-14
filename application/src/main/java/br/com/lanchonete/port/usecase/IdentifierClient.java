package br.com.lanchonete.port.usecase;

import br.com.lanchonete.model.Client;

import java.util.UUID;

public interface IdentifierClient {

    Client identifierByCPF(String cpf);

    Client identifierById(UUID id);

}
