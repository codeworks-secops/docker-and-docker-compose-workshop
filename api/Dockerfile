FROM maven:3-adoptopenjdk-8 as build

WORKDIR /wordsmith/api

COPY pom.xml .

RUN mvn verify

COPY src ./src

RUN mvn verify

FROM adoptopenjdk:8-jdk

WORKDIR app

COPY --from=build /wordsmith/api/target .

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx8m", "-Xms8m", "-jar", "words.jar"]
