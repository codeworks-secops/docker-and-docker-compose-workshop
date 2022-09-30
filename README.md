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

**NB** : For your local tests, you should export some environment variables to ensure that all modules can communicate : 

        WORDSMITH_API_SERVICE : locolhost

        POSTGRES_HOST_SERVICE : locolhost

1. Create a Dockerfile per project

   * Web : 
     * Path : /web/Dockerfile
   
   * App : 
     * Path : /app/Dockerfile
   
   * DB : 
     * Path : /db/Dockerfile


2. Test your solution


3. Any questions ?

***

## Solutions

Dockerfile : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-workshop/tree/dockerfile-deployment-solution)

Docker Compose : [click here](https://github.com/codeworks-secops/docker-and-docker-compose-workshop/tree/docker-compose-deployment-solution)
