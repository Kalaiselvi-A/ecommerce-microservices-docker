# 1️ Use lightweight Java runtime
FROM eclipse-temurin:17-jre-alpine

# 2️ Set working directory inside container
WORKDIR /app

# 3️ Copy JAR into container
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# 4️ Expose service port
EXPOSE 8082

# 5️ Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
