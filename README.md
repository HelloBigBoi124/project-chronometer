# 🏁 Race Timer - Timing System

![Java](https://img.shields.io/badge/Java-17%2B-orange)  
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)  
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

A complete system for timing racing teams, with database storage and report generation.

---

## 📚 Table of Contents

- [✨ Features](#-features)  
- [📋 Requirements](#-requirements)  
- [⚙️ Installation](#-installation)  
- [🏎️ Usage](#-usage)  
- [💻 Technologies](#-technologies)  
- [👥 Contributors](#-contributors)  
- [📄 License](#-license)  

---

## ✨ Features

- 🕒 Digital stopwatch with second precision  
- 🏎️ Lap control and split times  
- 💾 Data storage in MySQL database  
- 📊 Report generation with team rankings  
- 🖥️ Intuitive graphical interface built with Java Swing  
- ⏯️ Full race control: Start, Lap, Finish  
- 🔄 Automatic total time calculation  

---

## 📋 Requirements

Before starting, make sure you have the following installed:

- [Java JDK 17 or higher](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- [MySQL Server 8.0 or higher](https://dev.mysql.com/downloads/mysql/)  
- [Git](https://git-scm.com/) (optional, to clone the repository)

---

## ⚙️ Installation

1. **Clone the repository:**

```bash
git clone https://github.com/your-username/cronometro-corrida.git
```

2. **Open the project in your favorite IDE** (Eclipse, NetBeans, IntelliJ, etc.)

3. **Configure the MySQL database:**

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

4. **Update the database connection credentials in the Java code** if necessary (user, password, URL).

---

## 🏎️ Usage

1. Run the program through your IDE.  
2. Fill in the team and driver information.  
3. Use the available buttons to control the race:
   - ▶️ **Start**: Starts the stopwatch  
   - 🔄 **Lap**: Records the split time  
   - 🏁 **Finish**: Finalizes the team's total time  
   - 💾 **Save**: Stores the data in the database  
   - 📊 **Report**: Displays the team rankings based on total time  

---

## 💻 Technologies

| Technology | Version | Description            |
|------------|---------|------------------------|
| Java       | 17      | Main application logic |
| Swing      | 1.1     | Graphical user interface |
| MySQL      | 8.0     | Data storage            |
| JDBC       | 4.2     | Database connectivity   |

---

## 👥 Contributors

- [Heitor Carnielo Janko](https://github.com/HelloBigBoi124)  
- [Gabriel Soares](https://github.com/Gabriel485s)

---

