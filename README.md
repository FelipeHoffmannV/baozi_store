# 🥟 Baozi Store - Sistema de Gerenciamento Interno

A aplicação **Baozi Store** é um sistema administrativo interno leve e robusto, baseado em Java, projetado para gerenciar o cadastro de clientes, menus de disponibilidade de produtos e operações de vendas para uma loja fictícia. O projeto foi desenvolvido utilizando as tecnologias **Spring Boot 3**, **Spring Data JPA** e renderizado no lado do servidor via **Thymeleaf**.

---

## 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como parte integrante das atividades práticas do curso superior de tecnologia em **Análise e Desenvolvimento de Sistemas (ADS)**. O objetivo principal da aplicação é consolidar conhecimentos práticos em desenvolvimento web voltado ao ecossistema corporativo Java, aplicando conceitos essenciais como:
- Arquitetura em camadas (MVC).
- Persistência de dados em banco de dados relacional (MySQL).
- Mapeamento Objeto-Relacional (ORM) com Hibernate.
- Integração segura entre front-end dinâmico e back-end.

---

## 🚀 Principais Funcionalidades

- **👤 Gerenciamento de Clientes**: Cadastro de clientes e acompanhamento de metadados estruturais (como a data de adesão ao sistema).
- **📦 Catálogo de Produtos**: Manutenção do cardápio de sabores de pãezinhos, preços unitários e monitoramento explícito de disponibilidade por meio de chave liga/desliga (**Em Estoque / Esgotado**).
- **🛒 Histórico e Registro de Pedidos**: Registro de transações vinculando clientes específicos a produtos e quantidades desejadas, com cálculo automatizado do custo total agregado no servidor.

---

## 🛠️ Tecnologias e Ecossistema

- **Framework Backend**: Spring Boot 3.x
- **Persistência de Dados**: Spring Data JPA
- **Banco de Dados**: MySQL 8.x
- **Mecanismo de Template**: Thymeleaf (HTML5 / Recursos de Templates Naturais)
- **Design de Interface (UI)**: Bootstrap 5.0.2 (Entrega otimizada e ultra-rápida via CDN da Cloudflare)

---

## 📁 Estrutura Arquitetural de Pacotes

O sistema segue rigorosamente o padrão de separação de responsabilidades (MVC) estruturado abaixo:

```text
com.keeper.baozistore
  ├── controllers      # Camada Web: Controladores que gerenciam o fluxo MVC da aplicação
  ├── model            # Camada de Domínio: Entidades JPA que representam as tabelas relacionais
  └── repository       # Camada de Acesso a Dados: Interfaces que estendem o JpaRepository
```

---

## 🔧 Instalação e Configuração do Ambiente

### Pré-requisitos
- **Java Development Kit (JDK)**: Versão 17 ou superior
- **Gerenciador de Dependências**: Apache Maven 3.x
- **Banco de Dados**: Instância activa do MySQL

### 1. Inicialização do Banco de Dados Relacional
Acesse o seu cliente CLI local do MySQL ou o terminal do MySQL Workbench e execute o comando abaixo para provisionar um esquema limpo:

```sql
CREATE DATABASE baozistore;
```

### 2. Configurações da Aplicação
Navegue até o arquivo `src/main/resources/application.properties` e insira as propriedades de conexão com o banco de dados. Certifique-se de substituir o usuário e a senha padrão pelas credenciais do seu ambiente local:

```properties
# Configuração do DataSource (MySQL)
spring.datasource.url=jdbc:mysql://localhost:3306/baozistore?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=sua_senha_segura_aqui
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 3. Compilação e Execução
Execute a aplicação a partir do diretório raiz do projeto utilizando o seguinte comando do Maven:

```bash
mvn spring-boot:run
```

Assim que o servidor inicializar com sucesso, o painel administrativo estará acessível diretamente no endereço: `http://localhost:8080`.

---

## 🗃️ Modelo de Domínio Principal

### Entidade de Produto (`Produto.java`)
```java
@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Boolean estoque; // True = Em Estoque (Sim) | False = Esgotado (Não)

    // Getters e Setters...
}
```

---

## 🛣️ Rotas e Operações dos Controladores

| Endpoint / Mapeamento | Método | Ação Executada na Camada de Controle |
| :--- | :---: | :--- |
| `/` | `GET` | Renderiza o Painel Administrativo Central de Entrada. |
| `/clientes` | `GET` | Busca a grade unificada de clientes cadastrados e exibe na tabela. |
| `/clientes` | `POST` | Processa a inserção e persistência de uma nova entidade de cliente. |
| `/clientes/excluir/{id}` | `POST` | Executa a exclusão segura do registro usando validação em tela. |
| `/produtos` | `GET` | Abre o painel de gerenciamento de inventário e menu de produtos. |
| `/produtos` | `POST` | Adiciona ou atualiza um item no catálogo, incluindo o status de estoque. |
| `/produtos/excluir/{id}`| `POST` | Remove com segurança um produto específico do menu no banco de dados. |
| `/pedidos` | `GET` | Consolida o histórico de transações comerciais e monta os menus de seleção. |
| `/pedidos` | `POST` | Registra e valida uma nova movimentação de venda no livro-razão. |
| `/pedidos/excluir/{id}` | `POST` | Remove com segurança um fluxo de transação histórica. |

---

## ⚖️ Licença

Este projeto está distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para obter mais detalhes sobre as permissões de uso do sistema.
