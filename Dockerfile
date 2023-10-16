FROM openjdk:17-alpine

COPY ./src src/
COPY ./pom.xml pom.xml

RUN mvn clean packeg

FROM openjdk:17-alpine
COPY --from=builder target/*.jar app.jar
CMD ["java","-jar","app.jar"]
