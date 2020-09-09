#/bin/sh
mvn clean package -DskipTests && java -jar ./target/registration-service-1.0.0-SNAPSHOT.jar