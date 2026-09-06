#   Sistema Desktop integrado com Web
###
Repositório para um breve projetos acadêmico.

O primeiro a ser desenvolvido vai ser um sistema desktop em Java Swing, integrado com uma página Web por meio de uma API REST.

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
Sistema-Desktop/
│
├── src/
│   └── Main.java
│
└── README.md
```
