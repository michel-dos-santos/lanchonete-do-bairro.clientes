package br.com.lanchonete.port.repository;

public interface AuthClientProviderRepository {

    void signUp(String username, String password, String email);

    String signIn(String username, String password);

}
