# Docker & Docker Compose Workshop

In this workshop, we will work with the **Wordsmith** application which is the demo project shown at DockerCon EU 2017 and 2018.

**NB:** Please try to find your own solutions before getting response from the repository.

## Architecture Schema

![wordsmith-architcture](wordsmith-architecture.png   )

***

## Preamble

We have 3 containers to manage for Wordsmith App.

- **db** : is a Postgresql database which stores words like Nouns, Adjectives and Verbs.


- **api** : is a Java REST API which serves words read from the database and expose them through specific endpoints.


- **web** : is a Go web application which calls the **api** and builds words into sentences

***

## Instructions

1. Clone the project in your local machine.

```shell
git clone git@github.com:codeworks-secops/docker-and-docker-compose-workshop.git
```

2. Checkout the `dockerfile-deployment` branch to start.

```shell
git checkout dockerfile-deployment
```

***

### Use Docker Compose to containerise Wordsmith App

1. Create a new directory named `.dck` in the root of your local project


2. Create a new directory named `compose` inside `.dck` directory.


3. Create a new manifest file named `docker-compose.yml` inside `.dck/compose` directory.


4. Create 3 new services according to the architecture schema :
   
   - db : service to manage Postgresql database docker resources
   - api : service to manage API docker resources
   - web : service to manage WEB docker resources


5. Play with all commands offered by Docker Compose, like : build, images, ls, up, down, start, stop, logs,...


6. Test your Docker Compose manifest file.


7. Could you see your App deployed ?


8. If you prefer, push your 3 images to the Docker Hub using your personal docker hub access.

***

## Build and Run in Docker Compose

Before doing any action, be sure that your local volumes is ok.

If you want, you can remove all of unused volumes by executing the following command :

```shell
docker volume prune
```

The only requirement to build and run the app from source is Docker.


Clone this repo and use Docker Compose to build all your stuff.


Go to the **[.dck8s/compose](.dck8s/compose)** folder.


```shell
cd .dck8s/compose
```

You can use the new version of Compose with `docker compose` like :

```shell
docker compose --env-file .env.dev up --build -
```

Or the classic `docker-compose` CLI :

```shell
docker-compose build
```

And :

```shell
docker-compose --env-file .env.dev up -d 
```

Check that all 3 containers are running :

```
$ docker compose ls

NAME                STATUS
compose             running(3)
```

Check the services are up, and you should see output like this:

```
$ docker-compose ps

NAME                COMMAND                  SERVICE             STATUS              PORTS
compose-api-1       "java -Xmx8m -Xms8m …"   api                 running             0.0.0.0:8080->8080/tcp
compose-db-1        "docker-entrypoint.s…"   db                  running             0.0.0.0:5432->5432/tcp
compose-web-1       "/dispatcher"            web                 running             0.0.0.0:9090->80/tcp
```

Get a container IP Address :

```shell
docker inspect --format '{{ .NetworkSettings.Networks.compose_wordsmith_net.IPAddress  }}' <CONTAINER_NAME>
```

If you want to scale a specific service like api :

```shell
docker-compose --env-file .env.dev up -d --scale api=3
```

A quick check again :

```
$ docker-compose ps

compose-api-1       "java -Xmx8m -Xms8m …"   api                 running             0.0.0.0:8082->8080/tcp
compose-api-2       "java -Xmx8m -Xms8m …"   api                 running             0.0.0.0:8081->8080/tcp
compose-api-3       "java -Xmx8m -Xms8m …"   api                 running             0.0.0.0:8083->8080/tcp
compose-db-1        "docker-entrypoint.s…"   db                  running (healthy)   0.0.0.0:5432->5432/tcp
compose-web-1       "/dispatcher"            web                 running             0.0.0.0:9090->80/tcp
```

Tear down all services by executing this command :

```shell
docker-compose down
```

You should see output like this :

```
$ docker-compose down

[+] Running 4/4
 ⠿ Container compose-api-1  Removed                                                                                                                                                              0.6s
 ⠿ Container compose-web-1  Removed                                                                                                                                                              0.3s
 ⠿ Container compose-db-1   Removed                                                                                                                                                              0.3s
 ⠿ Network compose_default  Removed  
```

Check again if there are services up :

```
$ docker-compose ps

NAME                COMMAND                  SERVICE             STATUS              PORTS
```

## Solutions

Dockerfile : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-workshop/tree/dockerfile-deployment-solution)

Docker Compose : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-workshop/tree/docker-compose-deployment-solution)
