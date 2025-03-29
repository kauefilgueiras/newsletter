# Etapa 1: Build do projeto com Maven
FROM eclipse-temurin:21-jdk-alpine AS builder

# Define o diretório de trabalho no container
WORKDIR /app

# Copia todos os arquivos do projeto para dentro do container
COPY . .

# Dá permissão de execução para o Maven Wrapper (caso esteja no Linux)
RUN chmod +x mvnw

# Executa o build do projeto (sem rodar testes)
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final para rodar a aplicação
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório onde o app vai rodar
WORKDIR /app

# Copia o .jar gerado na build anterior para esta imagem final
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta usada pelo Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
