# Megafair

## Running the application
1) Execute to run db locally:
```shell script
docker run --rm=true --name postgres-quarkus-hibernate -e POSTGRES_USER=hibernate -e POSTGRES_PASSWORD=hibernate -e POSTGRES_DB=hibernate_db -p 5432:5432 postgres:14.1
```

2) Run start.sh to run applications:
```shell script
./start.sh
```

3) Execute init.sql to create necessary data for manual testing:
```shell script
./init.sql
```

4) Use postman collection in project root to test the application: api-test.postman_collection.json