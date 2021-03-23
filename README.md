# FhirResources
Dedalus java test

# Project build: from root directory of the project run:
mvn clean compile
mvn package

# docker image creation
cd docker
docker-compose build

# start the service and the database
docker-compose up -d

# test the application
curl \
  -v -X POST \
  -H "Content-Type: application/x-www-form-urlencoded" \
  "http://localhost:8080/rest-service-0.0.1-SNAPSHOT/transferFhirPatient" \
  -d 'fhirUrl=http://hapi.fhir.org/baseR4/Patient/1854776'
  
curl 'localhost:8080/rest-service-0.0.1-SNAPSHOT/transferedPatient/?fhirUrl=http://hapi.fhir.org/baseR4/Patient/1854776'

# stop the service and the database
docker-compose down

# restart the service and the database 
docker-compose up -d

# test the application (database tables are still present) 
curl 'localhost:8080/rest-service-0.0.1-SNAPSHOT/transferedPatient/?fhirUrl=http://hapi.fhir.org/baseR4/Patient/1854776'

# stop the service and the database and remove the volume
docker-compose down -v
