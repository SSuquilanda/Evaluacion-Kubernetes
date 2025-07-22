# Evaluación de Kubernetes

Este repositorio contiene un proyecto dividido en tres tareas que demuestran el proceso de desarrollo, containerización y despliegue de una aplicación Java en un clúster de Kubernetes.

## Estructura del Proyecto

-   `tarea 1/`: Contiene el código fuente de una API REST de Spring Boot.
-   `tarea 2/`: Incluye los archivos `Dockerfile` y `docker-compose.yml` para containerizar la aplicación.
-   `tarea 3/`: Contiene los manifiestos de Kubernetes (`.yml`) para desplegar la aplicación.

## Pasos para Ejecutar y Probar el Proyecto Completo

A continuación se describen los pasos para construir, containerizar y desplegar la aplicación en un entorno local con Docker y Kubernetes (por ejemplo, Docker Desktop, Minikube o Kind).

### Paso 1: Construir la Aplicación (Tarea 1)

El primer paso es compilar el código fuente de la API y generar el archivo `.jar`.

1.  Abre una terminal y navega al directorio de la Tarea 1:
    ```bash
    cd "tarea 1/universidades-api"
    ```

2.  Ejecuta el comando de Maven para limpiar y empaquetar el proyecto:
    ```bash
    ./mvnw clean package
    ```

3.  Verifica que el archivo `universidades-api-0.0.1-SNAPSHOT.jar` se ha creado en el directorio `target/`.

4.  Copia el archivo `.jar` generado al directorio de la Tarea 2 para que Docker pueda usarlo:
    ```bash
    cp target/universidades-api-0.0.1-SNAPSHOT.jar ../../"tarea 2"/
    ```

### Paso 2: Containerizar la Aplicación (Tarea 2)

Ahora, construiremos la imagen de Docker que contiene nuestra aplicación.

1.  Navega al directorio de la Tarea 2:
    ```bash
    cd ../../"tarea 2"
    ```

2.  Construye la imagen de Docker. Es importante etiquetar la imagen con un nombre que Kubernetes pueda encontrar. Si estás usando un registro local como el de Minikube o Docker Desktop, puedes usar un nombre simple. Si vas a subirla a un registro como Docker Hub, deberías usar `tu-usuario/tu-imagen:tag`.
    ```bash
    docker build -t universidades-api:latest .
    ```

    *Nota: Si estás usando Minikube, asegúrate de que tu terminal está usando el entorno de Docker de Minikube ejecutando `eval $(minikube -p minikube docker-env)` antes de construir la imagen.*

### Paso 3: Desplegar en Kubernetes (Tarea 3)

Finalmente, desplegaremos la aplicación en nuestro clúster de Kubernetes.

1.  Asegúrate de que tu `kubectl` está configurado para apuntar al clúster correcto.

2.  Navega al directorio de la Tarea 3:
    ```bash
    cd ../"tarea 3"
    ```

3.  Aplica los manifiestos en el orden correcto:
    ```bash
    # 1. Crea el Namespace
    kubectl apply -f namespace.yml

    # 2. Despliega la base de datos (si la hay)
    kubectl apply -f database-deployment.yml
    kubectl apply -f database-service.yml

    # 3. Despliega el backend (la API)
    kubectl apply -f backend-deployment.yml
    kubectl apply -f backend-service.yml
    ```

### Paso 4: Verificar el Despliegue

1.  Comprueba que los Pods se están ejecutando correctamente en el namespace `universidades`:
    ```bash
    kubectl get pods -n universidades
    ```
    Deberías ver los pods del backend y la base de datos en estado `Running`.

2.  Para acceder a la aplicación, necesitarás exponer el servicio. Si estás en un entorno local, puedes usar `port-forward`:
    ```bash
    # Reemplaza <nombre-del-pod-backend> con el nombre real de tu pod
    kubectl port-forward pod/<nombre-del-pod-backend> 8080:8080 -n universidades
    ```

3.  Ahora, la API debería estar accesible en `http://localhost:8080` en tu máquina local.
