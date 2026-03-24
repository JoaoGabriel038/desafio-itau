# 💰 Itaú - API de Transações e Estatísticas (In-Memory)
Este projeto foi desenvolvido como parte do desafio técnico para a vaga de Desenvolvedor Júnior no Itaú. A aplicação foca no processamento de transações financeiras e no cálculo de estatísticas agregadas em tempo real.

# 🏗️ Arquitetura e Organização
O projeto foi estruturado seguindo o padrão de Camadas, garantindo a separação de responsabilidades e facilitando a manutenção:

- Controller: Responsável pela exposição dos endpoints REST e validação inicial das requisições.

- Service: Onde reside a inteligência de negócio, validações de tempo/valor e o cálculo das estatísticas.

- DTO (Data Transfer Object): Utilizado para o tráfego de dados entre as camadas, evitando a exposição direta das entidades de negócio.

- Model: Representação dos dados da transação e do resumo estatístico.

# ⚙️ Decisões de Engenharia
1. Persistência em Memória (ArrayList)
Como o desafio restringia o uso de bancos de dados (SQL ou NoSQL), as transações são armazenadas em uma ArrayList gerenciada pela camada de serviço.

Nota de Performance: Para garantir a thread-safety (segurança em acessos simultâneos), a manipulação da lista foi pensada para manter a consistência dos dados durante o cálculo das estatísticas.

2. Processamento com Java Stream API
Para calcular o resumo estatístico nos últimos 60 segundos, utilizei a Stream API do Java 21. Isso permitiu filtrar e agregar os dados (count, sum, avg, min, max) de forma declarativa e performática.

3. Observabilidade com SLF4J
A aplicação faz uso intensivo de logs para monitorar:

Recebimento de transações.

Erros de validação (valores negativos ou datas futuras).

Performance do cálculo de estatísticas.

# 🛠️ Tecnologias Utilizadas
- Java 21 (LTS)

- Spring Boot 3.x

- Gradle (Gerenciador de build)

- SpringDoc OpenAPI (Swagger): Documentação interativa em http://localhost:8080/swagger-ui/index.html.

- SLF4J / Logback: Logging estruturado.

- Lombok: Redução de código boilerplate.
