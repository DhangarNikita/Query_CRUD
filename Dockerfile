FROM openjdk:17
WORKDIR /app
COPY target/query-crud.jar query-crud.jar
ENTRYPOINT ["java","-jar","query-crud.jar"]