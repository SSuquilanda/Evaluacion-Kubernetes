# Tarea 2: Dockerización del Microservicio y la Base de Datos

## Descripción
Esta tarea consiste en dockerizar el proyecto `UNIVERSIDADES-API` y levantarlo junto con una base de datos PostgreSQL usando `docker-compose`.

## Pasos para ejecutar

### 1. Compilar el proyecto (desde tarea1)
```bash
cd tarea1/UNIVERSIDADES-API
./mvnw clean package

Verifica en navegador o Postman:
http://localhost:8080/api/universidades
