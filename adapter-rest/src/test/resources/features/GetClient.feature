Feature: Obter dados do cliente
  Como sistema
  Quero poder recuperar os dados do cliente
  Para que eu possa usar suas informações para vincular no pedido

  Scenario: Tentativa de obter os dados do cliente inexistente
    Given que o sistema informa o identificador="00000000-0000-0000-0000-000000000000" do cliente
    And envia a requisição para url="http://localhost:8010/api/v1/clients/"
    Then a requisição retornará o status code 500
    And com o response contendo o identificador="Cliente não encontrado com base no id: 00000000-0000-0000-0000-000000000000"

  Scenario: Tentativa de obter os dados do cliente com sucesso
    Given que o sistema informa o identificador="770e8039-5be8-4066-9d75-846ce13baf13" do cliente
    And envia a requisição para url="http://localhost:8010/api/v1/clients/"
    Then a requisição retornará o status code 200
    And com o response contendo o identificador="770e8039-5be8-4066-9d75-846ce13baf13"





