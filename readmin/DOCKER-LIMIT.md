# 📄 `Limitar Memória de Contêiner Docker (MySQL)` — Obsidian

# 🐳 Docker - Limitar Memória do Contêiner MySQL

## ✅ Por que limitar a memória?
- Evita que o contêiner consuma toda a RAM do sistema.
- Protege o sistema operacional contra travamentos (ex: tela azul no Windows).
- Melhora a estabilidade de desenvolvimento e testes locais.
- Ajuda a identificar vazamentos ou uso exagerado de memória.

---
## Arquivo em: `C:\Users\<UserName>\.wslconfig`
### .wslconfig
```
[wsl2]
memory=4GB        # Limite de memória total para WSL2 + Docker
processors=2      # Número de CPUs
swap=1GB          # Memória swap
```

## 🧠 Como limitar a memória do contêiner

### Exemplo com Docker Compose:
```yaml
version: '3.8'

services:
  mysql:
    image: mysql
    ports:
      - "3307:3306"
    expose:
      - "3306"
    environment:
      - MYSQL_USER=springuser
      - MYSQL_PASSWORD=ThePassword
      - MYSQL_DATABASE=db_example
      - MYSQL_ROOT_PASSWORD=root
    volumes:
      - "./conf.d:/etc/mysql/conf.d:ro"
````

---
```bash
docker-compose up -d  // subir a imagem
docker-compose down // desligar
```

## ⚙️ Alternativa sem Swarm

Depois de subir com `docker-compose up`, aplique o limite manualmente:
## **AVISO: TROCAR O NOME CERTO DO PROJETO**
 - _PARA VER O NOME EXECUTE: **docker ps**_

```bash
docker update --memory=768m --memory-swap=1g --cpus=1 name
```

### _precisa executar quando: `docker-compose down` + `up` _
---

## 💡 Boas práticas

- Comece com `768MB` para MySQL em desenvolvimento.
    
- Evite definir valores muito baixos, como `128MB` ou `256MB`.
    
### Monitore o uso com:    
```
docker stats
```
### Você verá algo como:
```
matlab

CONTAINER ID   NAME           CPU %     MEM USAGE / LIMIT     ...
abcd1234       mysql_cursos   0.50%     100MiB / 512MiB        ...
```
Se a coluna **"MEM USAGE / LIMIT"** mostrar **`/ 512MiB`**, então o limite foi aplicado com sucesso. 

---
## ✅ Posso usar normalmente com limite?

Sim, desde que o valor definido seja suficiente.  
Com `512MB`, é possível usar MySQL para:

- Desenvolvimento local
    
- Testes com ORMs (Prisma, Sequelize, etc.)
    
- Aplicações com bases leves e médias
    

Se necessário, aumente para `768MB` ou `1GB`.

---