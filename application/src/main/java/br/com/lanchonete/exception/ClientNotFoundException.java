package br.com.lanchonete.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String field, String content) {
        super(String.format("Cliente não encontrado com base no %s: %s", field, content));
    }

}