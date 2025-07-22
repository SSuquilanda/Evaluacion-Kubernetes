# Tarea 3: Despliegue en Kubernetes

Este directorio contiene los manifiestos de Kubernetes (`.yml`) necesarios para desplegar la aplicación de universidades y su base de datos en un clúster.

## Manifiestos

-   `namespace.yml`: Crea un `Namespace` llamado `universidades` para aislar los recursos de esta aplicación.

    ```yaml
    apiVersion: v1
    kind: Namespace
    metadata:
      name: universidades
    ```

-   `database-deployment.yml`: Define el `Deployment` para la base de datos PostgreSQL.
-   `database-service.yml`: Expone la base de datos dentro del clúster con un `Service` de tipo `ClusterIP`.

    ```yaml
    apiVersion: v1
    kind: Service
    metadata:
      name: postgres
      namespace: universidades
    spec:
      type: ClusterIP
      selector:
        app: postgres
      ports:
        - port: 5432
          targetPort: 5432
    ```

-   `backend-deployment.yml`: Define el `Deployment` para la API de universidades, utilizando la imagen de Docker construida en la Tarea 2.

    ```yaml
    # ... (extracto)
    spec:
      template:
        spec:
          containers:
            - name: universidades-api
              image: ssuquilanda/universidades-api:latest
    # ... (resto del archivo)
    ```

-   `backend-service.yml`: Expone la API al exterior del clúster utilizando un `Service` de tipo `LoadBalancer`.

    ```yaml
    apiVersion: v1
    kind: Service
    metadata:
      name: universidades-api
      namespace: universidades
    spec:
      type: LoadBalancer
      selector:
        app: universidades-api
      ports:
        - port: 8080
          targetPort: 8080
    ```

## Cómo Desplegar

Para aplicar estos manifiestos, navega a este directorio y ejecuta:

```bash
kubectl apply -f namespace.yml
kubectl apply -f database-deployment.yml
kubectl apply -f database-service.yml
kubectl apply -f backend-deployment.yml
kubectl apply -f backend-service.yml
```
