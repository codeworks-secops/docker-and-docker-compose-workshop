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

2. Checkout the `code-base` branch to start.

```shell
git checkout code-base
```

***

### Case 1 : Use Dockerfile to containerise Wordsmith App

1. Create a Dockerfile per project

   * Web : 
     * Path : /web/Dockerfile
   
   * App : 
     * Path : /app/Dockerfile
   
   * Db : 
     * Path : /db/Dockerfile

2. Test your solution

### Case 2 : Use Docker Compose to containerise Wordsmith App

1. Create a new directory named `.dck8s` in the root of your local project


2. Create a new directory named `compose` inside `.dck8s` directory.


3. Create a new manifest file named `docker-compose.yml` inside `.dck8s/compose` directory.


4. Create 3 new services according to the architecture schema :
   
   - db : service to manage Postgresql database docker resources
   - api : service to manage API docker resources
   - web : service to manage WEB docker resources


5. Play with all commands offered by Docker Compose, like : build, images, ls, up, down, start, stop, logs,...


6. Test your Docker Compose manifest file.


7. Could you see your App deployed ?


8. If you prefer, push your 3 images to the Docker Hub using your personal docker hub access.

***

## Solutions

Docker : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-workshop/tree/docker-deployment)

Docker Compose : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-k8s-workshop/tree/docker-compose-deployment)
