#   Sistema Desktop integrado com Web
###
Repositório para um breve projeto acadêmico, com meio de praticar a linguagem de programação Java, bem como entender como funcionam API'S.

O projeto a ser desenvolvido é um sistema desktop em Java Swing, integrado com uma página Web por meio de uma API REST, esse sistea vai receber login e senha a primeiro momento.

### Arquitetura:
```
                    USUÁRIO
                        │
              ┌─────────┴─────────┐
              │                   │
              ▼                   ▼
           WEBSITE             DESKTOP
        HTML/CSS/JS             SWING
              │                   │
              │ HTTP/JSON         │ HTTP/JSON
              │                   │
              └─────────┬─────────┘
                        ▼
                    API REST
                       JAVA
                        │
                        ▼
                 REGRAS DE NEGÓCIO
                        │
                        ▼
                       CSV
```
### Integração:
Será utilizada nesse projeto uma API REST (Representational State Transfer), que vai fazer a comunicação entre os sistemas por meio do protocolo HTTP.

### Estrutura Atual:
```
SistemaProjetos/
│
├── src/
│   │
│   ├── Main.java
│   │
│   ├── model/
│   │   └── Projeto.java
│   │
│   ├── service/
│   │    └── PrjService.java
│   │
│   ├──dao/
│   │    └──PrjCSV
└── dados/
    └── dados.csv
```
### Sobre a Estrutura
- Projeto.java - Trata da representação dos dados.
- PrjService.java - Contém as regras de negócio.
- PrjCSV.java - Classe que lida com a persistência.
- Main - Interação com o usuário