 Sistema VIP Desktop: Interface Gráfica (GUI), API REST e Persistência em Java

Este é um projeto **Full-Stack Desktop** construído inteiramente em **Java puro**. Ele demonstra a integração entre uma interface gráfica de usuário (Front-end), regras de negócio, consumo de APIs da internet e gravação de dados em disco (Back-end).

 Funcionalidades Principais
* **Interface Gráfica (GUI):** Desenvolvida com a biblioteca nativa **Java Swing** (`JFrame`, `JLabel`, `JTextField`, `JButton`, `JOptionPane`), abandonando o terminal para oferecer uma experiência de usuário (UX) real e interativa.
* **Consumo de API REST Externa:** Utiliza o moderno `java.net.http.HttpClient` (introduzido no Java 11) para fazer requisições HTTP reais aos servidores do **ViaCEP**, buscando endereços completos de forma instantânea.
* **Processamento e Parsing de Dados:** Demonstra forte domínio de lógica e manipulação de Strings extraindo dados específicos (Logradouro, Bairro, UF) de um formato **JSON** bruto utilizando o método `.split()`, sem dependência de bibliotecas de terceiros.
* **Persistência de Dados (File I/O):** Todo convidado cadastrado é automaticamente salvo e formatado em um banco de dados local (arquivo `lista_vip.txt`) utilizando `FileWriter` e `PrintWriter`.

 Arquitetura e Aprendizados
O sistema foi arquitetado para ser um portfólio prático dos pilares da programação em Java:
1. **Event Listeners (`ActionListener`):** Captura de eventos assíncronos gerados por cliques do usuário.
2. **Tratamento de Exceções (`try/catch`):** Resiliência do código contra falhas de conexão de internet (HTTP) ou erros de permissão de gravação no disco rígido (I/O).
3. **Plano Cartesiano Visual:** Posicionamento absoluto de componentes (Layout `null` e `setBounds`) para construção de interfaces sob medida.

 Tecnologias Utilizadas
* **Java** (JDK 11+)
* **Java Swing & AWT** (Criação de Telas e Captura de Eventos)
* `java.net.http` (Comunicação com a Internet)
* `java.io` (Manipulação de Arquivos de Texto)

---
Desenvolvido por Italo Rocha de Almeida Ferreira - Estudante de Engenharia de Software
