## Cheatsheet docker client application

* Get the new version on: https://hub.docker.com/r/stefanesterer/docker-test-test/
* create a new image mvn compile jib:build
* run it docker run -d -p 8083:8080 --link greeting-postgres:database stefanesterer/docker-test-test
* Test it with for example httpie: http GET http://localhost:8083/greeting

## How to use postgres image

* docker run -p 5432:5432 --name greeting-postgres -e POSTGRES_DB=greeting -e POSTGRES_PASSWORD=mysecretpassword  -v /tmp/pg/greeting:/var/lib/postgresql/data -d postgres
* docker stop greeting-postgres
* docker rm greeting-postgres