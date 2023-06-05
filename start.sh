./generate_jwtKeys.sh
cd api
../mvnw clean compile package
cd ../jwt-auth
../mvnw clean compile package
cd ../
docker compose up