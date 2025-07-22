# Tarea 1: API de Universidades (Spring Boot)

Este directorio contiene el código fuente de una API RESTful desarrollada con Spring Boot y Java. La API gestiona una lista de universidades y expone endpoints básicos para interactuar con los datos.

## Prerrequisitos

- Java Development Kit (JDK) 11 o superior.
- Apache Maven.

## Cómo ejecutar la aplicación

1.  **Navega al directorio de la API:**
    ```bash
    cd "tarea 1/universidades-api"
    ```

2.  **Ejecuta la aplicación usando el wrapper de Maven:**
    Este comando compilará el proyecto y pondrá en marcha el servidor web Tomcat embebido.
    ```bash
    ./mvnw spring-boot:run
    ```

La API estará disponible en `http://localhost:8080`.

## Cómo construir el archivo .jar

Para empaquetar la aplicación en un archivo `.jar` ejecutable, puedes usar el siguiente comando:

```bash
./mvnw clean package
```

El archivo resultante (`universidades-api-0.0.1-SNAPSHOT.jar`) se encontrará en el directorio `target/`. Este archivo es el que se utiliza en la Tarea 2 para la containerización.
