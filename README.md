# Newsletter Backend

Este é um projeto backend para gerenciamento de posts de uma newsletter, desenvolvido em Java com Spring Boot e Maven.

## Funcionalidades

- Cadastro de posts (título, conteúdo, autor, descrição, imagem, URL)
- Listagem de posts
- Atualização e remoção de posts
- Validações de dados e datas

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven
- JPA/Hibernate
- Banco de dados relacional (ex: PostgreSQL, H2)
- Jakarta Persistence

## Como rodar o projeto

1. **Clone o repositório:**
   `git clone <URL_DO_REPOSITORIO> cd newsletter-backend`
   
2. **Configure o banco de dados**  
   Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu banco.

3. **Compile e execute:**
`./mvnw spring-boot:run`

4. **Acesse a API:**  
   O backend estará disponível em `http://localhost:8080`.

## Estrutura do Projeto

- `models/` - Entidades e DTOs
- `repositories/` - Interfaces de acesso a dados
- `services/` - Lógica de negócio
- `controllers/` - Endpoints REST

## Exemplos de Endpoints

- `POST /posts` - Cria um novo post
- `GET /posts` - Lista todos os posts
- `GET /posts/{id}` - Busca post por ID
- `PUT /posts/{id}` - Atualiza um post
- `DELETE /posts/{id}` - Remove um post
