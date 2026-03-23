 Sistema VIP Desktop: GUI, API REST e Banco de Dados (SQLite)

Este é um projeto **Full-Stack Desktop** construído em **Java**. Ele demonstra a integração ponta a ponta de uma aplicação real: desde a interface gráfica do usuário (Front-end), passando por regras de negócio e consumo de APIs externas (Back-end), até a persistência estruturada em um banco de dados relacional.

 Funcionalidades Principais
* **Interface Gráfica (GUI):** Construída nativamente com **Java Swing** (`JFrame`, `JLabel`, `JTextField`, `JButton`), proporcionando uma experiência de usuário (UX) fluida e interativa.
* **Consumo de API REST Externa:** Utiliza `java.net.http.HttpClient` para realizar requisições HTTP aos servidores do **ViaCEP**, processando dados em formato **JSON** para autocompletar endereços de forma dinâmica e extraindo as informações via manipulação avançada de Strings (`.split()`).
* **Banco de Dados Relacional (SQLite):** Substitui a gravação simples em arquivos de texto por um banco de dados embutido estruturado. Utiliza o driver **JDBC** para realizar conexões seguras e executar comandos DDL (`CREATE TABLE`) e DML (`INSERT INTO`).
* **Segurança de Dados:** Implementação de `PreparedStatement` nas transações com o banco de dados para garantir a integridade das informações e prevenir vulnerabilidades como SQL Injection.

 Arquitetura e Aprendizados
O sistema foi arquitetado para ser um portfólio prático de engenharia de software, evidenciando:
1. **Event-Driven Programming:** Captura e tratamento de eventos assíncronos (`ActionListener`).
2. **Integração de Sistemas:** A capacidade de fazer o Java conversar fluidamente com a internet (HTTP) e com o disco rígido (I/O e SQL) no mesmo fluxo de execução.
3. **Tratamento de Exceções:** Uso estratégico de blocos `try/catch` para blindar a aplicação contra quedas de internet ou falhas de conexão com o driver do banco.

 Tecnologias Utilizadas
* **Linguagem:** Java (JDK 11+)
* **Front-end:** Java Swing & AWT
* **Integração:** `java.net.http` (APIs REST)
* **Banco de Dados:** SQLite e `java.sql` (JDBC)

---
*Desenvolvido por Italo Rocha de Almeida Ferreira - Estudante de Engenharia de Software*
