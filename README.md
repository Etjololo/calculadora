# calculadora
Prueba Back Microservicio Calculadora
- Comando a ejecutar (estando localizados en la carpeta donde se encuentre el fichero "tracer-1.0.0.jar"):
  - mvn install:install-file -Dfile="tracer-1.0.0.jar" -DgroupId=com.tracerjar -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
- Comandos a ejecutar (estando localizados en la carpeta del proyecto):
  - mvn clean package
  - java -jar target/calculadora-0.0.1-SNAPSHOT.jar

