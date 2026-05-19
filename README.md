# Gerenciamento de Clientes e Produtos

Nome: Davi Bomfim Climaco  
RA: 24038233-2  
Turma: ESOFT 5S - C  

API REST desenvolvida em Spring Boot utilizando Java 11 para gerenciamento de clientes e produtos. Para testar a aplicação no Postman, primeiro execute o projeto e verifique se ele iniciou na porta `8080`. Para cadastrar um cliente, utilize uma requisição `POST` para `http://localhost:8080/clientes` enviando um JSON com nome, email e telefone. Para cadastrar um produto em um cliente, utilize `POST http://localhost:8080/produtos/{idCliente}` enviando nome e preço do produto no body. Também é possível listar, buscar, atualizar e deletar clientes e produtos utilizando os métodos `GET`, `PUT` e `DELETE`. O projeto utiliza banco H2 em memória para testes.
