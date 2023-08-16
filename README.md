### Imágenes

- [Maven](https://hub.docker.com/_/maven)
- [MySQL](https://hub.docker.com/_/mysql)

### Apagar mysql local

- `Win` + `R`
- Introducir `services.msc`
- Buscar el servicio de MySQL
- Detenerlo

### Comandos

- Ejecutar el docker-compose para genera la red y la base de datos: `docker compose up`
- Ejecutar Dockerfile para generar la imagen con maven incluido: `docker build -t back-base:latest .`
- Ejecutar imagen para compilar el proyecto: `docker run -it back-base:latest mvn clean package`
- Generar una nueva imagen pero ahora con el jar: `docker build -t back-base:0.0.1 .`
- Crear el contenedor que ejecuta el jar pero integrado a la red: `docker run -p 8080:8080 --network bootcampbase-rest_net back-base:0.0.1`

