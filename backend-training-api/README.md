# Execute with Docker

* Create Network.
```
docker create network [network_name]
```

* Execute MySQL Database Image.
```
docker run -p 3306:3306 --name db_mysql_backend_training --network [network_name] -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=db_student -d mysql:[tag] 
```

* Build the API in Image.
```
docker build -t backend-training .
```

* Run API Image.
```
docker run --name service-api-backend-training --network [network_name] -it -p 8080:8080 backend-training
```

# Upload in DockerHub
* Build the API in Image.
```
docker build -t [user_dockerhub]/backend-training .
```

* Upload Image to Repository.
```
docker push [user_dockerhub]/backend-training
```