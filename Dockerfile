FROM gradle:7.6.0-jdk17 AS build

WORKDIR /app

COPY . .

RUN gradle build --no-daemon

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/ms-franquicias-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080


CMD ["java", "-jar", "app.jar"]