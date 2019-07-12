mvn package spring-boot:repackage -DskipTests=true
cp discovery/target/discovery-1.0.0-SNAPSHOT.jar docker/files/discovery.jar
cp cep-rest-consumer/target/cep-rest-consumer-1.0.0-SNAPSHOT.jar docker/files/cep-rest-consumer.jar
cp gateway/target/gateway-1.0.0-SNAPSHOT.jar docker/files/gateway.jar
sudo docker build --file=docker/Dockerfile --tag=alpine-java:base --rm=true .
sudo docker-compose --file=docker/docker-compose.yml up --build
