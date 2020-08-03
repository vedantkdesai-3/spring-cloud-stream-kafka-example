mvn -f consumer/pom.xml clean install 
mvn -f producer/pom.xml clean install 
docker-compose -f "docker-compose.yml" down
docker-compose -f "docker-compose.yml" up -d --build