# Projeto Spring Boot - Escolar API
 
Bem-vindo ao projeto Escolar API, um exemplo de aplicação Spring Boot para gerenciamento de informações escolares exemplo: cadastro de curso e gestão de usuários entre outros. \
Esta aplicação é desenvolvida em Java e usa o framework Spring Boot.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de iniciar:

- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [MongoDB](https://www.mongodb.com/)


## Configuração do Projeto

1. **Clone este repositório para o seu ambiente local:**

'https://github.com/gilneiaquino/escolar-api.git'
 

2. ** Navegue até o diretório do projeto:**
/
cd escolar-api

### 3.Inicie o MongoDB com o Docker:


Utilize o Docker Compose para iniciar o MongoDB:

### 4.Build do Projeto:
Execute o comando Maven para construir o projeto:

mvn clean install

### 5. Inicie o aplicativo:
Execute o aplicativo Spring Boot:

mvn spring-boot:run

O aplicativo estará disponível em http://localhost:8080.

<br> 

Claro, vou atualizar o README para incluir informações sobre o uso do Docker e do banco de dados MongoDB. Aqui está a versão atualizada:

### Projeto Spring Boot - Escolar API
Spring Boot Logo

 Bem-vindo ao projeto Escolar API, um exemplo de aplicação Spring Boot para gerenciamento de informações escolares. Esta aplicação é desenvolvida em Java e usa o framework Spring Boot.

Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas antes de iniciar:

Java 17
Maven
Docker
MongoDB
Configuração do Projeto
Clone este repositório para o seu ambiente local:

bash
Copy code
git clone https://seurepositorio.git
Navegue até o diretório do projeto:

bash
Copy code
cd escolar-api
Inicie o MongoDB com o Docker:

Utilize o Docker Compose para iniciar o MongoDB:

bash
Copy code
docker-compose up -d
Build do Projeto:

Execute o comando Maven para construir o projeto:

bash
Copy code
mvn clean install
Inicie o aplicativo:

Execute o aplicativo Spring Boot:

bash
Copy code
mvn spring-boot:run
O aplicativo estará disponível em http://localhost:8080.

## Tecnologias Usadas

Spring Boot 3.1.5
Spring Boot Web Starter
Spring Boot DevTools
Spring Boot Docker Compose
Spring Boot Starter Test
Spring Boot Starter Data MongoDB
Mockito
Jackson Mapper ASL
Jackson Databind
JUnit Jupiter
Spring Boot Starter Validation
Spring Boot Starter Security
MongoDB (Banco de Dados)

## Endpoints da API
Descreva os principais endpoints da sua API e como usá-los. Por exemplo:

GET /api/usuarios: Recupera a lista de usuários. <br>
POST /api/usuarios: Cria um novo usuário.<br>
GET /api/usuarios/{id}: Recupera um usuário por ID.<br>
PUT /api/usuarios/{id}: Atualiza um usuário por ID.<br>
DELETE /api/usuarios/{id}: Exclui um usuário por ID.<br>

# Documentação
Documente as informações adicionais relevantes sobre o seu projeto aqui.
Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) ou solicitações de pull (pull requests).

# Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais detalhes.

