# Fórum Hub

O Fórum Hub é uma API REST desenvolvida com o objetivo de simular o funcionamento de um fórum de discussão, similar ao utilizado pela plataforma Alura. Esta aplicação foi construída como parte do desafio proposto pelo programa Oracle Next Education (ONE), em parceria com a Alura, visando o aprimoramento de habilidades práticas no desenvolvimento backend com Java e Spring Boot.

## Descrição

A aplicação permite a realização de operações de cadastro, listagem, atualização e exclusão de usuários, tópicos e respostas. Também implementa autenticação e autorização por meio de JWT, garantindo segurança no acesso aos recursos. Além disso, a API é documentada com Swagger (OpenAPI 3.1), possibilitando a visualização e teste dos endpoints de forma interativa.

## Recursos Implementados

- **Autenticação de usuários** com geração de token JWT.
- **CRUD de usuários**: criação, leitura, atualização e exclusão.
- **CRUD de tópicos**: com suporte a detalhamento por ID.
- **CRUD de respostas**: com associação a tópicos e atualização automática do status do tópico.
- **Controle de acesso** aos endpoints com segurança baseada em token.
- **Documentação da API** acessível via Swagger UI.
- **Paginação e ordenação** nos endpoints de listagem.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Flyway
- Lombok
- MySQL
- Swagger (OpenAPI 3.1)
- JWT (JSON Web Token)
- Maven

## Documentação

A documentação da API está disponível em:

```
http://localhost:8080/swagger-ui/index.html
```

Contrato da API (OpenAPI):

```
/v3/api-docs
```

## Estrutura dos Endpoints

### Autenticação

- `POST /login` – Autentica o usuário e retorna um token JWT.

### Usuários

- `GET /usuarios` – Lista todos os usuários.
- `GET /usuarios/{id}` – Retorna um usuário pelo ID.
- `POST /usuarios` – Cadastra um novo usuário.
- `PUT /usuarios` – Atualiza os dados de um usuário.
- `DELETE /usuarios/{id}` – Remove um usuário.

### Tópicos

- `GET /topicos` – Lista todos os tópicos.
- `GET /topicos/{id}` – Retorna os detalhes de um tópico.
- `POST /topicos` – Cadastra um novo tópico.
- `PUT /topicos` – Atualiza os dados de um tópico.
- `DELETE /topicos/{id}` – Remove um tópico.

### Respostas

- `GET /respostas` – Lista todas as respostas.
- `GET /respostas/{id}` – Retorna uma resposta específica.
- `POST /respostas` – Cadastra uma nova resposta e atualiza o status do tópico para "RESPONDIDO".
- `PUT /respostas` – Atualiza os dados de uma resposta.
- `DELETE /respostas/{id}` – Remove uma resposta.

## Autor

**Henrique Guilherme de Jesus Hernandes**  
Email: henriquedejesushernandes@gmail.com  
LinkedIn: [https://www.linkedin.com/in/henrique-hernandes/](https://www.linkedin.com/in/henrique-hernandes/)  
GitHub: [github.com/HenriqueDeJesus](https://github.com/HenriqueDeJesus)
