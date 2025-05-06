# 📈 Calculadora de Juros

Projeto Java desenvolvido para calcular **juros simples** e **juros compostos** de forma prática e objetiva. Ideal para estudos, testes matemáticos e simulações financeiras.

## 💻 Tecnologias Utilizadas

* Java 17+
* Gradle (Kotlin DSL)

## 🚀 Funcionalidades

* Cálculo de **juros simples**:

  * Fórmula: `J = C * i * t`
* Cálculo de **juros compostos**:

  * Fórmula: `M = C * (1 + i)^t`
* Interface por linha de comando (CLI)

## 📂 Estrutura do Projeto

```
CalculadoraJuros/
├── app/                   # Código-fonte principal
├── gradle/                # Configurações do Gradle
├── build.gradle.kts       # Script de build (Kotlin DSL)
├── settings.gradle.kts    # Configurações do projeto
└── ...
```

## 🛠️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/Saravtb/CalculadoraJuros.git
cd CalculadoraJuros
```

### 2. Compile o projeto com o Gradle

No Linux/macOS:

```bash
./gradlew build
```

No Windows:

```cmd
gradlew.bat build
```

### 3. Execute a aplicação

```bash
./gradlew run
```

> Certifique-se de estar usando Java 17 ou superior.

---

## 🧪 Como Usar

Ao executar o programa, você será guiado via terminal com instruções para inserir os seguintes dados:

### Exemplo de Juros Simples

**Entrada:**

```
Tipo de cálculo: simples
Capital: 1000
Taxa de juros (%): 5
Tempo (meses): 12
```

**Saída:**

```
Juros simples: R$600.00
Montante total: R$1600.00
```

### Exemplo de Juros Compostos

**Entrada:**

```
Tipo de cálculo: composto
Capital: 1000
Taxa de juros (%): 5
Tempo (meses): 12
```

**Saída:**

```
Montante com juros compostos: R$1795.86
```

> A aplicação considera a taxa de juros informada como percentual mensal. O tempo é informado em meses.

---





