# TE1
## Maven
### Arborescence Maven:
<pre>
my-app
|-- pom.xml
\`-- src
    |-- main
    |   \`-- java
    |       \`-- com
    |           \`-- mycompany
    |               \`-- app
    |                   \`-- App.java
    \`-- test
        \`-- java
            \`-- com
                \`-- mycompany
                    \`-- app
                        \`-- AppTest.java
</pre>

### Build avec Maven:
> ```mvn package```

## Docker

### Lancer une appli dans un container:
> ```docker run -dp 127.0.0.1:3000:3000 getting-started```

Le premier 3000 est le port de notre machine et le deuxieme celui du container. </br>
```-d``` pour lancer en arrière plan et ```-p``` pour lancer sur des ports donné. </br>
Pas obligatoire d'utiliser le 127.0.0.1 car il lance en localhost.

### Build une image
> ```docker build -t getting-started .```

Ici le getting-started est un dockerfile (sans extension) de type:
<pre>
# syntax=docker/dockerfile:1

FROM node:18-alpine
WORKDIR /app
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]
EXPOSE 3000
</pre>

### Docker compose

>```docker compose up -d```


>```docker compose logs -f```

>```docker compose down```


### Commandes utiles
>```docker ps```

Vois tous les programmes qui tournent

>```docker stop <id-container>```

>```docker rm <id-container>```

>```docker image ls```

>```docker image rm <id-image>```

## Tester client/server
### Pour tester client:
1. Lancer dans le terminal la commande ```nc -v -l <numport>```
1. Lancer la capture wireshark
1. Lancer le programme client sur un IDE
### Pour tester server:
1. Lancer dans le terminal la commande ```nc localhost <numport>```
1. Lancer la capture wireshark
1. Lancer le programme server sur un IDE
