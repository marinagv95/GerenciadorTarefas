# 📂 Gerenciador de Tarefas

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow.svg?style=for-the-badge)]()

Sistema simples de gerenciamento de tarefas com base em menus e classes orientadas a objetos. Criado como projeto acadêmico no curso de Sistemas de Informação da **UNIFACISA**.

---

## 📜 Sumário

- [📦 Sobre o Projeto](#-sobre-o-projeto)
- [🚀 Funcionalidades](#-funcionalidades)
- [🧠 Conceitos Aplicados](#-conceitos-aplicados)
- [📁 Estrutura do Projeto](#-estrutura-do-projeto)
- [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [🧪 Como Executar](#-como-executar)
- [📝 Licença](#-licença)
- [👩‍💻 Autora](#-autora)

---

## 📦 Sobre o Projeto

O **Gerenciador de Tarefas** é uma aplicação Java para terminal que permite:

- Cadastro de usuários
- Criação de tarefas simples e com prazos
- Acompanhamento do status das tarefas
- Navegação facilitada por menus

Desenvolvido com foco na prática de princípios de **Programação Orientada a Objetos (POO)**.

---

## 🚀 Funcionalidades

- ✅ Cadastro de usuários
- ✅ Criação de tarefas simples
- ✅ Criação de tarefas com prazo
- ✅ Edição e visualização de tarefas
- ✅ Filtro por status
- ✅ Interface baseada em menus no terminal

---

## 🧠 Conceitos Aplicados

- Encapsulamento, herança e polimorfismo
- Composição de objetos
- Enumerações
- Separação de responsabilidades (MVC simplificado)
- Modularização de menus e modelos

---

## 📁 Estrutura do Projeto

src
└── br.com.maisunifacisa
├── enums
│ └── Status.java
├── menus
│ ├── MenuTarefa.java
│ ├── MenuUsuario.java
│ └── SubmenuListagem.java
└── models
├── GerenciadorTarefas.java
├── Tarefa.java
├── TarefaComPrazo.java
├── TarefaSimples.java
├── Usuario.java
└── Main.java

yaml
Copiar
Editar

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **IntelliJ IDEA** (recomendado)
- **Paradigma O.O.**

---

## 🧪 Como Executar

### Pré-requisitos
- JDK instalado (versão 17 ou superior)
- IDE de sua escolha (IntelliJ, Eclipse, VS Code, etc.)

### Passos

```bash
# Clone o repositório
git clone https://github.com/marinagv95/GerenciadorTarefas.git

# Acesse o diretório
cd GerenciadorTarefas

# Abra o projeto na sua IDE
Execução
Navegue até o arquivo Main.java

Execute como aplicação Java

📝 Licença
Este projeto está licenciado sob a Licença MIT.

