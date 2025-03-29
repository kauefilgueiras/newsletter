FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR para esse diretório com nome padronizado
COPY target/newsletter-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pela aplicação (opcional)
EXPOSE 8080

# Roda o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]