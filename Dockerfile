# Estágio de build
FROM maven:3.9.6-eclipse-temurin-21 AS builder # Ou outra imagem Maven/JDK 21
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:21-jdk-alpine # Ou outra imagem JDK 21
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080 # Porta que sua aplicação Spring Boot escuta
ENTRYPOINT ["java", "-jar", "app.jar"]