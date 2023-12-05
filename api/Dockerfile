FROM maven:3.8.5-jdk-17-slim

WORKDIR app
COPY . .

ENTRYPOINT ["mvn", "spring-boot:run"]