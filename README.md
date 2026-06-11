# Simple Java App - CI/CD Demo

Project Java Maven sederhana untuk demonstrasi pipeline CI/CD dari build hingga deployment.

## 🛠️ Tech Stack

- **Language**: Java 17
- **Build Tool**: Apache Maven
- **Testing**: JUnit 5
- **CI/CD**: GitHub Actions

## 📁 Struktur Project

```
Simple/
├── .github/
│   └── workflows/
│       └── ci-cd.yml          # GitHub Actions pipeline
├── src/
│   ├── main/
│   │   └── java/com/example/
│   │       ├── App.java               # Entry point aplikasi
│   │       ├── CalculatorService.java # Service kalkulator
│   │       └── GreetingService.java   # Service sapaan
│   └── test/
│       └── java/com/example/
│           ├── CalculatorServiceTest.java
│           └── GreetingServiceTest.java
├── .gitignore
├── pom.xml                    # Maven configuration
└── README.md
```

## 🚀 Menjalankan Secara Lokal

### Prasyarat
- Java 17+
- Maven 3.8+

### Build & Run

```bash
# Compile
mvn compile

# Jalankan unit test
mvn test

# Build JAR
mvn package

# Jalankan aplikasi
java -jar target/simple-app-1.0.0.jar
```

## ⚙️ CI/CD Pipeline

Pipeline GitHub Actions terdiri dari 2 stage:

| Stage | Trigger | Deskripsi |
|-------|---------|-----------|
| **Build & Test** | Setiap push & PR | Compile, test, dan package JAR |
| **Deploy** | Push ke `main` | Deploy JAR ke server via SSH/SCP |

### Alur Pipeline

```
Push ke GitHub
     │
     ▼
┌─────────────┐
│ Build & Test│ ← mvn compile + mvn test + mvn package
└──────┬──────┘
       │ (jika lolos & branch main)
       ▼
┌─────────────┐
│   Deploy    │ ← SCP JAR ke server → java -jar
└─────────────┘
```

## 🔑 GitHub Secrets yang Diperlukan

Tambahkan secrets berikut di **Settings → Secrets → Actions**:

| Secret | Deskripsi |
|--------|-----------|
| `SSH_HOST` | IP atau hostname server production |
| `SSH_USERNAME` | Username SSH server |
| `SSH_PRIVATE_KEY` | Private key SSH (RSA/ED25519) |
| `SSH_PORT` | Port SSH server (default: 22) |

## 🧪 Test Coverage

- `CalculatorServiceTest` → 14 test cases (add, subtract, multiply, divide)
- `GreetingServiceTest` → 8 test cases (greet, greetFormal, edge cases)
