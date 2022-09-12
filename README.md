# quarkus-super-hero

Esta aplicacion es un ejemplo de como crear una aplicacion con quarkus.

## Requisitos
* Java 11 o superior
* Maven 3.6.2 o superior
* GraalVM 20.1.0 o superior
* Docker 19.03.8 o superior
* Docker Compose 1.25.5 o superior

## Ejecutar la aplicacion
Para ejecutar la aplicacion se debe ejecutar el siguiente comando:

```bash
mvn quarkus:dev
```

## Crear una imagen nativa
Para crear una imagen nativa se debe ejecutar el siguiente comando:

```bash
mvn package -Pnative
```

## Iniciar imagenes de docker
Para esto se debe navegar hasta el directorio quarkus-workshop-super-heroes/super-heroes/infrastructure y ejecutar el siguiente comando:

```bash
docker compose -f docker-compose.yaml up -d
```

## Verificar que los contenedores esten corriendo
Para esto se debe ejecutar el siguiente comando:

```bash
docker compose -f docker-compose.yaml ps
```
La salida debe ser similar a la siguiente:

```bash
     Name                   Command               State           Ports
--------------------------------------------------------------------------------
kafka            sh -c bin/kafka-server-sta ...   Up      0.0.0.0:9092->9092/tcp
super-database   docker-entrypoint.sh postgres    Up      0.0.0.0:5432->5432/tcp
super-visor      /bin/prometheus --config.f ...   Up      0.0.0.0:9090->9090/tcp
zookeeper        sh -c bin/zookeeper-server ...   Up      0.0.0.0:2181->2181/tcp
```

## Apagar imagenes de docker y eliminar volumenes
Para esto se debe ejecutar el siguiente comando:

```bash
docker compose -f docker-compose.yaml down
docker compose -f docker-compose.yaml rm
```

## NOTA
Si se usa rancher desktop se debe maximizar la memoria de la maquina virtual de docker para que la aplicacion funcione correctamente.

# Autor
John Santa

# Referencias
* https://quarkus.io/quarkus-workshops/super-heroes
