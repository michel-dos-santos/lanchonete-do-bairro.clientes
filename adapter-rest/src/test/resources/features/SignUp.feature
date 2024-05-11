Feature: Cadastro
  Como usuário
  Quero poder me cadastrar
  Para que eu possa usar os serviços oferecidos pela Lanchonete do bairro

  Scenario: Tentativa de cadastro faltando o name
    Given que o cliente informa os dados de name="", cpf="30452581079", email="email@email.com", password="cde3#EDC"
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="Nome não pode ser vazio ou nulo" do cadastro

  Scenario: Tentativa de cadastro faltando o cpf
    Given que o cliente informa os dados de name="João Pedro", cpf="", email="email@email.com", password="cde3#EDC"
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="CPF não pode ser vazio ou nulo" do cadastro

  Scenario: Tentativa de cadastro faltando o email
    Given que o cliente informa os dados de name="João Pedro", cpf="30452581079", email="", password="cde3#EDC"
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="Email não pode ser vazio ou nulo" do cadastro

  Scenario: Tentativa de cadastro faltando o password
    Given que o cliente informa os dados de name="João Pedro", cpf="30452581079", email="email@email.com", password=""
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="Senha não pode ser vazio ou nulo" do cadastro

  Scenario: Tentativa de cadastro sem respeitar a definição minima de cada caracteres
    Given que o cliente informa os dados de name="João Pedro", cpf="30452581079", email="email@email.com", password="1"
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="Senha deve ter no mínimo 8 e no máximo 99 caracteres" do cadastro

  Scenario: Tentativa de cadastro com o cpf invalido
    Given que o cliente informa os dados de name="João Pedro", cpf="12345678905", email="email@email.com", password="cde3#EDC"
    And envia a requisição de cadastro para url="http://localhost:8010/api/v1/clients/sign-up"
    Then a requisição retornará o status code 400 indicando inconsistência no cadastro
    And com o response com a mensagem="CPF inválido" do cadastro



