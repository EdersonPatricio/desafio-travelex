# README - Fcamara | Desafio Técnico Travelex 🚀

## Descrição 📝

Este projeto consiste na implementação de uma API (backend) de acordo com o que foi pedido. O projeto é desenvolvido em Java com o framework Spring Boot. Além disso, foi implementado Swagger para facilitar a visualização dos casos de uso da API, e também utilizo a biblioteca lombok.

## API (Backend) 💻

A API é responsável por fornecer 1 endpoint para realizar o cálculo do imc a partir do peso e altura informados. O microserviço contém controller e service. Além disso, possui também as classes solicitadas( Cliente, Gerente e Robo ). Optei por utilizar herança com Cliente e Gerente( ambas são Pessoa e Pessoa tem Identificacao ) e composição com Robo( Robo tem Identificacao ), visto que Robo não pode ser Pessoa.
Também foram implementados testes unitários para a classe controller( DesafioTravelexApplicationTests.java ) e para as classes do pacote model( ClassesModelTests.java ).

## Tecnologias Utilizadas 🛠️

- Java 11
- Spring Boot
- Maven
- Swagger

## Configuração do Ambiente ⚙️

Antes de executar o projeto, certifique-se de ter o seguinte configurado em sua máquina:

- JDK 11 (Java Development Kit)
- IDE (Eclipse, IntelliJ, ou outra IDE)
- Instalação do lombok.jar( https://projectlombok.org ) na IDE( Ex.: [https://ia-tec-development.medium.com/lombok-como-instalar-na-spring-tool-suite-4-ide-48defb1d0eb9](https://ia-tec-development.medium.com/lombok-como-instalar-na-spring-tool-suite-4-ide-48defb1d0eb9) )

## Execução ▶️

Para executar o projeto, siga estas etapas:

1. Clone este repositório em sua máquina local.
2. Abra o projeto em sua IDE.
3. Inicie a API (Backend).
4. Acesse a documentação do Swagger para visualizar e testar o endpoint.

## Documentação da API 📖

Após iniciar a aplicação, você pode acessar a documentação da API por meio do Swagger. Abra seu navegador e navegue para [http://localhost:8080/swagger-ui.html#/desafio-travelex-controller](http://localhost:8080/swagger-ui.html#/desafio-travelex-controller).
Lá, você encontrará uma descrição do endpoint disponível, bem como a capacidade de testá-lo diretamente do navegador.

## Contribuição 🤝

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request para propor melhorias ou correções.

## Contato 📧

Para mais informações ou dúvidas, entre em contato com [edersonpatricio25@gmail.com](edersonpatricio25@gmail.com).
