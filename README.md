# Megafair

## Running the application
1) Run start.sh to run applications:
```shell script
./start.sh
```

2) Execute to run db locally:
```shell script
docker run --rm=true --name postgres-quarkus-hibernate -e POSTGRES_USER=hibernate -e POSTGRES_PASSWORD=hibernate -e POSTGRES_DB=hibernate_db -p 5432:5432 postgres:14.1
```

3) Execute init.sql to create necessary data for manual testing:
```shell script
./init.sql
```

4) Go to http://localhost:8082/q/swagger-ui/ and receive JWT

5) Go to http://localhost:8081/q/swagger-ui/ and authorize using received JWT

6) Request to test api:
```
{
"platformName": "platform1",
"requestedResource": "game1"
}
```

> **_NOTE:_** Links to swagger-ui to test application: 
> http://localhost:8081/q/swagger-ui/,
> http://localhost:8082/q/swagger-ui/