Feature: Login
  Como usuário
  Quero poder me identificar
  Para que eu possa usar os serviços oferecidos pela Lanchonete do bairro

  Scenario: Tentativa de login faltando o username
    Given que o cliente informa os dados de username="", password="cde3#EDC"
    And envia a requisição de login para url="http://localhost:8010/api/v1/clients/sign-in"
    Then a requisição retornará o status code 400 indicando inconsistência no login
    And com o response com a mensagem="CPF não pode ser vazio ou nulo" do login

  Scenario: Tentativa de login faltando o password
    Given que o cliente informa os dados de username="30452581079", password=""
    And envia a requisição de login para url="http://localhost:8010/api/v1/clients/sign-in"
    Then a requisição retornará o status code 400 indicando inconsistência no login
    And com o response com a mensagem="Senha não pode ser vazio ou nulo" do login

  Scenario: Tentativa de login sem respeitar a definição minima de cada caracteres
    Given que o cliente informa os dados de username="30452581079", password="1"
    And envia a requisição de login para url="http://localhost:8010/api/v1/clients/sign-in"
    Then a requisição retornará o status code 400 indicando inconsistência no login
    And com o response com a mensagem="Senha deve ter no mínimo 8 e no máximo 99 caracteres" do login





