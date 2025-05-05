# 🏁 Cronômetro de Corrida - Sistema de Temporização

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![License](https://img.shields.io/badge/License-MIT-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

Um sistema completo para cronometragem de equipes em corridas, com armazenamento em banco de dados e geração de relatórios.

## 📚 Índice
- [Funcionalidades](#✨-funcionalidades)
- [Pré-requisitos](#📋-pré-requisitos)
- [Instalação](#⚙️-instalação)
- [Uso](#🏎️-uso)
- [Tecnologias](#💻-tecnologias)
- [Contribuidores](#👥-contribuidores)
- [Licença](#📄-licença)

## ✨ Funcionalidades
- 🕒 Cronômetro digital com precisão de segundos
- 🏎️ Controle de voltas e tempos parciais
- 💾 Armazenamento em banco de dados MySQL
- 📊 Geração de relatórios com rankings
- 🖥️ Interface gráfica intuitiva com Java Swing
- ⏯️ Controle de fluxo da corrida (Iniciar/Volta/Fim)
- 🔄 Cálculo automático de tempo total

## 📋 Pré-requisitos
- Java JDK 17+
- MySQL Server 8.0+
- Git (opcional)

## ⚙️ Instalação
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/cronometro-corrida.git
```

2. Importe o projeto na sua IDE favorita (Eclipse/NetBeans)

3. Configure o banco de dados:
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

## 🏎️ Uso
1. Preencha os dados da equipe e piloto
2. Controle a corrida:
   - ▶️ `Iniciar`: Inicia o cronômetro
   - 🔄 `Volta`: Registra tempo parcial
   - 🏁 `Fim`: Finaliza a sessão
   - 💾 `Salvar`: Armazena no banco de dados
   - 📊 `Relatório`: Exibe os tempos salvos


## 💻 Tecnologias
| Tecnologia       | Versão    | Uso                |
|------------------|-----------|--------------------|
| Java             | 17        | Lógica principal   |
| Swing            | 1.1       | Interface Gráfica  |
| MySQL            | 8.0       | Armazenamento      |
| JDBC             | 4.2       | Conexão com BD     |

## 👥 Contribuidores

- Heitor Carnielo Janko
- Gabriel Soares

---