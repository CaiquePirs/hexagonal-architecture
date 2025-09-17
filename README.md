# 🧱 Arquitetura Hexagonal com Java, Spring Boot, MongoDB e Kafka

Este projeto foi desenvolvido como parte de um exercicio passado em um curso da Udemy, com foco em aplicar os conceitos de arquitetura limpa, separação de responsabilidades e comunicação entre camadas por meio de portas e adaptadores.

## 🚀 Objetivo

Demonstrar na prática como estruturar microsserviços utilizando a arquitetura hexagonal (Ports & Adapters), integrando com banco de dados NoSQL (MongoDB), mensageria (Apache Kafka) e REST APIs, utilizando Java e Spring Boot.

## 🧩 Tecnologias e Ferramentas

- **Java 17**
- **Spring Boot 3**
- **MongoDB**
- **Apache Kafka**
- **Docker & Docker Compose**
- **WireMock** (para mockar serviços)
- **MapStruct & Lombok**

## 🧭 Estrutura Hexagonal

O projeto é dividido em três camadas principais:

          +-----------------------------+
          |         Domain Core         |
          |  (Entidades + UseCases)     |
          +-----------------------------+
                   ↑           ↑
                   │           │
        +----------------+   +----------------+
        |    Input       |   |    Output    |
        | (Controllers)  |   | (Kafka, Mongo) |
        +----------------+   +----------------+

- **Domain**: contém os casos de uso e entidades puras.
- **Adapters**: implementações concretas para entrada (REST) e saída (Kafka, MongoDB).
- **Application**: orquestra os fluxos entre portas e adaptadores.

## 📦 Funcionalidades

- [x] CRUD completo de clientes
- [x] Validação de CPF via mensageria (Kafka)
- [x] Persistência em MongoDB
- [x] Simulação de microserviço com WireMock

## 📚 Aprendizados

- Aplicação prática da arquitetura hexagonal em microsserviços
- Separação clara entre domínio e infraestrutura
- Comunicação assíncrona com Kafka
- Organização de pacotes por contexto e responsabilidade

## 🎓 Curso de origem

Este projeto foi desenvolvido com base no curso da Udemy:

## 📜 Licença

Este projeto é de uso pessoal e educacional. Sinta-se livre para estudar, adaptar e evoluir com base nele.

---

