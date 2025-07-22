# Tarea 2: Containerización con Docker

Este directorio contiene los archivos necesarios para containerizar la API de universidades (desarrollada en la Tarea 1) utilizando Docker.

## Archivos

-   `Dockerfile`: Define los pasos para construir la imagen de Docker para la aplicación Spring Boot.
-   `docker-compose.yml`: Orquesta la creación y ejecución de los contenedores para la aplicación y la base de datos (si la hubiera).
-   `universidades-api-0.0.1-SNAPSHOT.jar`: El archivo JAR ejecutable de la aplicación, generado en la Tarea 1.

## Cómo construir y ejecutar con Docker

1.  **Navega a este directorio:**
    ```bash
    cd "tarea 2"
    ```

2.  **Construye la imagen y levanta los contenedores:**
    ```bash
    docker-compose up --build
    ```

    Este comando leerá el `Dockerfile` para construir la imagen de la API y luego usará `docker-compose.yml` para iniciar el contenedor de la aplicación.

3.  **Verifica que la aplicación está corriendo:**
    Una vez que los contenedores estén en marcha, la API será accesible en `http://localhost:8080` desde tu máquina local.

## Cómo detener los contenedores

Para detener y eliminar los contenedores, puedes usar el siguiente comando en el mismo directorio:

```bash
docker-compose down
```