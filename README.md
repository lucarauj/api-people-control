[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucarauj/api-people-control/blob/main/LICENSE)

<h1 align="center"> API People Control: </h1>
<h2 align="center"> Gerenciando cadastro de Pessoas e Endereços </h2>

<p align="center"><img width="150px" src="https://github.com/lucarauj/assets/blob/main/ApiJavaSpring.png" /></p>

### ⛏ Criação do projeto base com as seguintes dependências:

- Spring Data JPA
- Spring Web
- H2 database
- Lombok
- Validation
- Spring Doc WebMVC UI

### ⚙ Configurando o arquivo application.properties

```
server.port=8080

spring.datasource.url=jdbc:h2:mem:people-control 
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

spring.jpa.defer-datasource-initialization=true
```
### ✔ Swagger (URL 👉 [🖱](http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs&validatorUrl=)) 
<img width="800px" src="https://github.com/lucarauj/api-people-control/blob/main/images/Swagger.png"/>

### ❌ Requisições:

<img width="800px" src="https://github.com/lucarauj/api-people-control/blob/main/images/Requisicoes.png"/>

### ▶ Utilizando o Postman:

- POST PESSOA
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/POST%20pessoa.png"/>

- POST ENDERECO
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/POST%20endereco.png"/>

- PUT PESSOA
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/PUT%20pessoa.png"/>

- PUT ENDERECO
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/PUT%20endereco.png"/>

- PUT ENDERECO PRINCIPAL
<img width="750px" src="https://github.com/lucarauj/api-people-control/blob/main/images/PUT%20endereco%20principal.png"/>

- GET PESSOA
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/GET%20pessoa.png"/>

- GET PESSOAS
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/GET%20pessoas.png"/>

- GET ENDERECOS PESSOA
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/GET%20enderecos%20pessoa.png"/>

- GET ENDERECO PRINCIPAL PESSOA
<img width="850px" src="https://github.com/lucarauj/api-people-control/blob/main/images/GET%20endereco%20principal%20pessoa.png"/>

### 🚀 Principais tecnologias utilizadas no projeto:

<div style="display: inline_block"><br>
<img align="center" alt="Lucarauj-Java" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
<img align="center" alt="Lucarauj-Postman" height="50" width="90" src="https://github.com/lucarauj/assets/blob/main/postman.png">
<img align="center" alt="Lucarauj-Spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg">
<img align="center" alt="Lucarauj-SpringBoot" height="40" width="110" src="https://github.com/lucarauj/assets/blob/main/SpringBoot.jpeg">
<img align="center" alt="Lucarauj-Maven" height="50" width="60" src="https://github.com/lucarauj/assets/blob/main/Maven-Apache.svg">
<img align="center" alt="Lucarauj-H2" height="30" width="30" src="https://github.com/lucarauj/assets/blob/main/H2.png">
</div>

## Autor

#### Lucas Araujo

<a href="https://www.linkedin.com/in/lucarauj"><img alt="lucarauj | LinkdeIN" width="40px" src="https://user-images.githubusercontent.com/43545812/144035037-0f415fc7-9f96-4517-a370-ccc6e78a714b.png" /></a>
