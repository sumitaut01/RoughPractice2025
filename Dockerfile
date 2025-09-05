# ===============================
# Stage 1 - Build + Run Tests
# ===============================
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy full source
COPY . .

# Run tests (reports will be generated here)
CMD ["mvn", "clean", "test"]
