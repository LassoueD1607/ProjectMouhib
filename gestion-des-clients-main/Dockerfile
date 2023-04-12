FROM maven:3.8.6-openjdk-11

EXPOSE 8080

USER root

WORKDIR /src
COPY . .

RUN apt update
RUN mvn clean install

CMD ["mvn","spring-boot:run"]