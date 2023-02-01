FROM openjdk:11

COPY target/*.jar calculadora.jar

ENTRYPOINT ["java","-jar","/calculadora.jar"]