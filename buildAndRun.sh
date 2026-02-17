#!/bin/sh
mvn clean package && docker build -t org.example/hello-todo .
docker rm -f hello-todo || true && docker run -d -p 8086:8080 -p 4849:4848 --name hello-todo org.example/hello-todo
