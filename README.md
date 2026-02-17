# Build
mvn clean package && docker build -t org.example/hello-todo .

# RUN

docker rm -f hello-todo || true && docker run -d -p 8080:8080 -p 4848:4848 --name hello-todo org.example/hello-todo 



java -jar payara-micro-5.2021.1.jar --deploy test-app.war --outputUberJar test-app.jar
