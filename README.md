## How to use postgres image

* docker run -p 5432:5432 --name greeting-postgres -e POSTGRES_DB=greeting -e POSTGRES_PASSWORD=mysecretpassword  -v /tmp/pg/greeting:/var/lib/postgresql/data -d postgres
* docker stop greeting-postgres
* docker rm greeting-postgres