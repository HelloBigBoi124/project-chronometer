# 🏁 Cronômetro de Corrida - Sistema de Temporização

![Java](https://img.shields.io/badge/Java-17%2B-orange)  
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)  
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

Sistema completo para cronometragem de equipes em corridas, com persistência de dados em banco de dados e geração de relatórios com ranking.

---

## 📚 Índice

- [✨ Funcionalidades](#-funcionalidades)  
- [📋 Pré-requisitos](#-pré-requisitos)  
- [⚙️ Instalação](#-instalação)  
- [🏎️ Uso](#-uso)  
- [💻 Tecnologias](#-tecnologias)  
- [👥 Contribuidores](#-contribuidores)  
- [📄 Licença](#-licença)  

---

## ✨ Funcionalidades

- 🕒 Cronômetro digital com precisão de segundos  
- 🏎️ Controle de voltas e registro de tempos parciais  
- 💾 Armazenamento dos dados em banco de dados MySQL  
- 📊 Geração de relatórios com rankings de equipes  
- 🖥️ Interface gráfica intuitiva construída com Java Swing  
- ⏯️ Controle completo da corrida: Início, Volta, Finalização  
- 🔄 Cálculo automático do tempo total de corrida  

---

## 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado:

- [Java JDK 17 ou superior](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- [MySQL Server 8.0 ou superior](https://dev.mysql.com/downloads/mysql/)  
- [Git](https://git-scm.com/) (opcional, para clonar o repositório)

---

## ⚙️ Instalação

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/cronometro-corrida.git
```

2. **Abra o projeto em sua IDE favorita** (Eclipse, NetBeans, IntelliJ, etc.)

3. **Configure o banco de dados MySQL:**

```sql
CREATE DATABASE bd_relatorio;

USE bd_relatorio;

CREATE TABLE RELATORIOS (
    COD_EQUIPE INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NOME_EQUIPE VARCHAR(255) NOT NULL,
    NOME_PILOTO VARCHAR(255) NOT NULL,
    TEMPO_TOTAL VARCHAR(255) NOT NULL,
    TEMPO_TOTAL_SEG INT NOT NULL
);
```

4. **Atualize as credenciais de acesso ao banco de dados no código Java**, se necessário (usuário, senha, URL).

---

## 🏎️ Uso

1. Execute o programa pela IDE.  
2. Preencha os dados da equipe e do piloto.  
3. Utilize os botões disponíveis para controlar a corrida:
   - ▶️ **Iniciar**: Inicia o cronômetro  
   - 🔄 **Volta**: Registra o tempo parcial  
   - 🏁 **Fim**: Finaliza o tempo total da equipe  
   - 💾 **Salvar**: Armazena os dados no banco de dados  
   - 📊 **Relatório**: Exibe o ranking das equipes com base no tempo total  

---

## 💻 Tecnologias

| Tecnologia | Versão | Descrição               |
|------------|--------|--------------------------|
| Java       | 17     | Lógica principal do sistema |
| Swing      | 1.1    | Interface gráfica         |
| MySQL      | 8.0    | Armazenamento dos dados   |
| JDBC       | 4.2    | Comunicação com o banco   |

---

## 👥 Contribuidores

- [Heitor Carnielo Janko](https://github.com/HelloBigBoi124)  
- [Gabriel Soares](https://github.com/Gabriel485s)

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
