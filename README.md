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

## Crear una imagen nativa con docker
Para crear una imagen nativa con docker se debe ejecutar el siguiente comando:

```bash
mvn package -Pnative -Dquarkus.native.container-build=true
```

## Crear una imagen nativa con docker y docker compose
Para crear una imagen nativa con docker y docker compose se debe ejecutar el siguiente comando:

```bash
mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker
```

## Pruebas
Para ejecutar las pruebas se debe ejecutar el siguiente comando:

```bash
mvn test
```

## Documentacion
Para ver la documentacion de la aplicacion se debe ejecutar el siguiente comando:

```bash
mvn quarkus:dev -Dquarkus.swagger-ui.always-include=true
```

# Autor
John Santa

# Licencia
MIT

# Referencias
* https://quarkus.io/quarkus-workshops/super-heroes
