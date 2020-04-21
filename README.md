
# Aplicação DOE Mais

Exemplo de uma aplicação em Spring Boot e Netflix OSS utilizando fundamentos das boas práticas de arquitetura de microserviços.

## Construído com:

- [Spring Boot](https://spring.io/projects/spring-boot) - Responsável por criar o microserviço e realizar o seu processamento e persistência.
- [Maven](https://maven.apache.org/) - Ferramenta de build automático.
- [Junit](https://junit.org/junit5/) - Ferramenta utilizar para criação dos testes unitários.
- [Mockito](https://site.mockito.org/) - Ferramenta utilizada para realizar mock de objetos referente a limitação de ambiente(dev,teste e produção).
- [Docker](https://www.docker.com/) - Ferramenta utilizada para simular o ambiente de testes de forma íntegra.
- [Insominia](https://insomnia.rest/) - Ferramenta utilizada para realizar testes de chamadas via rest.
- [Swagger](https://swagger.io/) - Ferramenta utilizada para documentação da API construída neste projeto.
- [Jenkins](https://jenkins.io/) - Ferramenta responsável pela execução da automatização de testes e integração contínua.
- [Spring Netflix Eureka](https://spring.io/projects/spring-cloud-netflix/) - Service Discovery responsável por unificar o registros dos microserviços.
- [Spring Feign](https://spring.io/projects/spring-cloud-openfeign/) - Reponsável por executar o Load Balance através do Ribbon na chamada de intgração dos microserviços.
- [Spring Sleuth](https://spring.io/projects/spring-cloud-sleuth/) - Responsável por realizar o trace de log através de um identificador único(Trace ID). 
- [Zuul-Gateway](https://spring.io/projects/spring-cloud-sleuth/) - Responsável por se conectar com o eureka e expor via gateway os microserviços registrados.

## Arquitetura

- Montei o fluxograma abaixo para representar de maneira ilustrativa como foi aplicado cada tecnologia e como se relacionam.

<img src="img/archtecture1.png">

## Microserviços

- http://localhost:5555/ - Zuul-Gateway -  Responsável por centralizar as chamadas externas
- http://localhost:8761/ - Eureka-Server - Service Discovery responsável por registar os microserviços
- http://localhost:8089/ - Spring Admin -  Monitora os microserviços
- http://localhost:8088/ - Authenticator - Responsável por realizar autenticação e autorização utilizando OAuth2
- http://localhost:8080/ - DonatePlusApi - Responsável por expor endpoints de cadastro de doadores, ongs e campanhas
- http://localhost:8082/ - PaymentApi -    Responsável por disponbilizar o serviço de transaçao das doações

## Configurações

| Spring Cloud components         | Resources  |
|---------------------------------|------------|
| Configuration server            | [Config server properties](spring-petclinic-config-server/src/main/resources/application.yml) and [Configuration repository] |
| Service Discovery               | [Eureka server](spring-petclinic-discovery-server) and [Service discovery client](spring-petclinic-vets-service/src/main/java/org/springframework/samples/petclinic/vets/VetsServiceApplication.java) |
| API Gateway                     | [Zuul reverse proxy](spring-petclinic-api-gateway/src/main/java/org/springframework/samples/petclinic/api/ApiGatewayApplication.java) and [Routing configuration](https://github.com/spring-petclinic/spring-petclinic-microservices-config/blob/master/api-gateway.yml) |
| Docker Compose                  | [Spring Boot with Docker guide](https://spring.io/guides/gs/spring-boot-docker/) and [docker-compose file](docker-compose.yml) |
| Circuit Breaker                 | [Hystrix fallback method](spring-petclinic-api-gateway/src/main/java/org/springframework/samples/petclinic/api/application/VisitsServiceClient.java)  |
| Grafana / Prometheus Monitoring | [Micrometer implementation](https://micrometer.io/), [Spring Boot Actuator Production Ready Metrics] |


## Service Discovery

- Responsável por facilitar a comunicação entre 1 ou mais microserviços. Os microserviços se registram no Eureka e passam a ser chamado pelos demais através de sua alias.
Este ponto ajuda bastante quando temos vários microserviços na solução e bem como mais de uma instância.

- No exemplo abaixo é possível identificar dois serviços registrados no Eureka. o donateplusapi e o payment, dado a explicação acima podemos imaginar um cenário onde tivéssemo
uma alto volume de requisições de pagamento por um período sazonal. Com a arquitetura proposta é possível duplicar o serviços de payment e registrar no Eukera realizando o
balance do volume de requisições.

<img src="img/eureka2.png">

## Monitoramento

- Atualmente a ferramanta mais utilizada por grande empresas para monitoramento de microserviços é o Splunk. Neste caso aqui fiz a utilização de um projeto chamado 
Spring Admin. A sua configuração é bem simples e sua interface é bastante amigável.

- Visualização de Dashboard 

<img src="img/spring_admin3.png">

- Detalhes de consumo e uso de memória

<img src="img/spring_admin2.png">

## Frontend - Angular

```sh
$ npm install
$ ng serve -o
```

<img src="img/frontend2.png">

## Solução
