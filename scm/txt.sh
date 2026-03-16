echo "STEP 1 : Build Spring Boot Project"
./mvnw clean install -DskipTests

echo "STEP 2 : Run Tests"
./mvnw test

echo "STEP 3 : SonarQube Analysis"
./mvnw clean verify sonar:sonar \
  -Dsonar.token=$SONAR_TOKEN \
  -Dsonar.organization=dhangarnikita \
  -Dsonar.projectKey=DhangarNikita_Query_CRUD \
  -Dsonar.host.url=https://sonarcloud.io