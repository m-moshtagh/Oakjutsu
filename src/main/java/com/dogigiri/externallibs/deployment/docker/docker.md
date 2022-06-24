# Docker

---

## Basic Concepts

### History

In old days we had one server per app. so, we had to acquire Big Strong servers so
most of the time the resources got wasted. Then VMare came with hypervisor solution
in order to allocate resources to multiple virtual machines.
But now we had the problem of that each vm was like a separated System which needed
to be configured. The OS and all apps.

This is where containers joined the game. We still had the big strong hardware but
instead of hypervisor and multiple OSs we had One OS. Then on top of that we created
containers for each app. Each container is a slice of the OS.

![docker intro](./pics/dockerintro1.png)

Run a Container:

* Download desired containerized app from docker hub as image
* run the image with the options and BOOM magic happens

Containers are the basic of microservice architecture, so we can say goodbye to good old monolithic applications.

### What is Docker?

Docker is an Open Source software meant to give us ability to deploy our application everywhere.

Java gives us WORA(write once run anywhere) which we take the bytecode anywhere and JVM can run it. However, our
application is combination of different tools, libs, OS etc. So for deployment we need all of them. Using Docker We
can package all of them and run them in one piece. PODA(package once deploy anywhere)

### Docker Mission

At high perspective, docker mission is to Build, Ship and Run the application. Docker provides tools to serve this
purpose. Result of this is a fully distributed application which can be run on cloud, datacenter and individual laptop.
We just need a docker engine.

![Docker mission](./pics/dockermission.png)

### Docker vs VM

![Docker vs VM](./pics/dockervsvm.png)

> Virtual machines take much more resources than Docker images and also work like a separate computer so, we need to do
> all stuff from zero in it.

### Docker Workflow

We have a Docker CLI which is the way to talk to docker. Docker host is the main part where everything happens.
Registry is where everybody pushes their image(dockerhub).

![Docker Workflow](./pics/dockerworkflow.png)

## Dockerfiles & Images

In docker the way we create an image is using a dockerfile. Each image is built from base image which it goes like
this till one parent is created from scratch image which is the equivalent of Object class in Java.
Each command in dockerfile creates layers. Each layer is a readonly cache image which docker can use to create other
images from them. Docker also adds a writable layer at top which allows to change configurations or run commands.
This is why multiple containers have same characteristic but different configuration. After deleting container
the writable layer will be deleted so, we can use Volumes or Bind mounts.

![Dockerfile commands](./pics/dockerfilecommands.png)

```Dockerfile
FROM java
COPY target/hello.jar /usr/src/hello.jar
CMD java -cp /usr/src/hello.jar # or .example.App
```

### Run helloWorld with docker

We use for building this, we use bind mount and give jar file to it. If we have the bytecode Using a jre is enough.

`docker run -v ${PWD}:/hello -w /hello openjdk:11.0.10-buster javac Hello.java`
`docker run -v ${PWD}:/hello -w /hello openjdk:11.0.10-jre-buster java Hello`

### Create a dockerfile to run simple jar file

We can use a base image using `FROM` command, `FROM ubuntu` will set ubuntu image as the base image. We can use
`RUN` command to execute a shell command. We can either type command or use array form:
`RUN ["executable", "param1", "param2"]`
using `WORKDIR` we can set working directory.
using `COPY` command we can copy the jar file to the working directory. `ADD` can do the same but `COPY` is the
most used case.
using `EXPOSE` we can document which port is usable. So we can expose it in `docker run` command.
We can set the initial command using `ENTRYPOINT` which we use it in array way to execute the final instruction.
we can use Command `CMD` instead.

Then we can build it using `docker build`.
-f is for specifying dockerfile name and, it's not necessary if the file name is just dockerfile.
we can use -t to specify image name.

![dockerfile](./pics/dockerram1.png)
![dockerfile](./pics/dockerram2.png)
![dockerfile](./pics/dockerram3.png)
![dockerfile](./pics/dockerram4.png)

> We create a dockerignore file to exclude unnecessary files to add to context of docker image.
> It's also mandatory to read the images dockerfiles so, we can understand how they work.

### Create a dockerfile to run simple war file inside tomcat

As we read the tomcat dockerfile we can understand that we need to copy the war file inside `${CATALINA_HOME}/webapps`
so the tomcat can host the app.

```Dockerfile
FROM tomcat:9
COPY web.war ${CATALINA_HOME}/webapps/root.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]
```

Then we just build and use it.

### Create a dockerfile to run simple jar file using maven

```Dockerfile
FROM maven:3.6.3-jdk-11-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/api.jar"]
```

If we change the source code, and run it again we can see that dependencies are cached but after pom is
modified it will download it again so, we need to use volume.

`docker run -it --rm -v ${PWD}:/app -v ${HOME}/.m2:/root/.m2 -w /app maven:3.6.3-jdk-11-slim mvn clean package`

### Create a dockerfile to run simple jar file using gradle

```Dockerfile
FROM gradle:jdk11
USER gradle
WORKDIR /app
COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle src src
RUN gradle build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/api.jar"]
```

`docker run -it --rm -u gradle -v ${PWD}:/app -v ${HOME}/.gradle:/home/gradle/.gradle -w /app gradle:jdk11 gradle build`

### Multi stage builds

This enables us to define multiple intermediate images stages. The dockerfile can have multiple FROM instructions. Each
starts with a new stage with new build context. We can copy to other stages using `--from` if we declare an alias for
FROM instructions.

#### MAVEN TOMCAT

```Dockerfile
FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package

FROM tomcat:9
COPY --from=build /app/target/web.war ${CATALINA_HOME}/webapps/root.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]
```

#### GRADLE TOMCAT

```Dockerfile
FROM gradle:jdk11 AS build
USER gradle
WORKDIR /app
COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle src src
RUN gradle build

FROM tomcat:9
COPY --from=build /app/build/libs/web.war ${CATALINA_HOME}/webapps/root.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]
```

### Memory and CPU options in containers

![dockerRam](./pics/dockerram5.png)
![dockerRam](./pics/dockerram6.png)
![dockerRam](./pics/dockerram7.png)
![dockerRam](./pics/dockerram8.png)
![dockerRam](./pics/dockerram9.png)
![dockerRam](./pics/dockerram10.png)
![dockerRam](./pics/dockerram11.png)
![dockerRam](./pics/dockerram12.png)
![dockerRam](./pics/dockerram13.png)
![dockerRam](./pics/dockerram14.png)
![dockerRam](./pics/dockerram15.png)
![dockerRam](./pics/dockerram16.png)
![dockerRam](./pics/dockerram17.png)
![dockerRam](./pics/dockerram18.png)

### Dockerfile Best practices

* Containers Should be ephemeral. Which means we should make sure there is no state stored in them. Databases are
  exception.
* use .dockerignore file. We create a directory and put docker file and all the files which we want in the image.
* Avoid installing unnecessary packages.
* Run only one process per container.
* Each instruction in image will create a layer and, we need to minimize the number of layers.

### Build & Run Image

We can easily create an image from dockerfile by <br/>`docker build -t docker_image_name`<br/>
We can also run it with <br/>`docker run -it docker_image_name`

After container exits, we can view them by `docker ps` and remove the exited containers by <br/>
`docker rm $(docker ps -aq)`<br/>

For some tools like database, web servers which we may need a port we can run them with port forwarding:
<br/> `docker run -it -p 8080:8080 docker_image_name`<br/>

We can also run it in detached mode with `-d` instead of `-it`. this will run the container in the background which
is visible with `docker ps` command.

## Docker machine

We can use this tool to create a docker host on a computer or a cloud provider. This is for mac and windows which
need a virtual-machine to run docker.

`docker-machine create --driver=virtualbox docker_host_name`<br/>
Then we can configure docker client to talk to it, create and pull images, start, stop and restart containers and
upgrade Docker.

After creation, we can give it a docker cli:

`docker-machine env docker_host_name` <br> this will provide us the details to use the machine. Then we can do all
regular stuff with it.
![docker machine](./pics/dockermachine1.png)
![docker machine](./pics/dockermachine2.png)

## Workflow for Java developers

We can configure maven plugin to update docker image after every push and also run the test in docker image and push
it in a registry.

### Docker maven plugin fabric8

We can pick up a docker maven plugin, and configure it to build an image for us on maven build phase and start the
container on installation phase. io.fabric8 is the recommended docker plugin. Spotify has one too which is inactive.

![fabric8](./pics/fabric81.png)
![fabric8](./pics/fabric82.png)
![fabric8](./pics/fabric83.png)
![fabric8](./pics/fabric84.png)
![fabric8](./pics/fabric85.png)

### Docker Gradle plugin Palantir

![pluntir](./pics/pluntir1.png)
![pluntir](./pics/pluntir2.png)
![pluntir](./pics/pluntir3.png)
![pluntir](./pics/pluntir4.png)

### Layered deployment with spring boot

![](./pics/springdocker1.png)
![](./pics/springdocker2.png)
![](./pics/springdocker3.png)
![](./pics/springdocker4.png)
![](./pics/springdocker5.png)
![](./pics/springdocker6.png)
![](./pics/springdocker7.png)
![](./pics/springdocker8.png)
![](./pics/springdocker9.png)
![](./pics/springdocker10.png)
![](./pics/springdocker11.png)

### Google JIB

![](./pics/jib1.png)
![](./pics/jib2.png)
![](./pics/jib3.png)
![](./pics/jib4.png)

## Docker Compose

In an application we have webserver, database server, messaging server and lots of other components and, we need each
scale up and down. This is where docker compose comes in the game.

We define configuration in one or more files which the default is `docker-compose.yml`. We can override the default
using `docker-compose.override.yml`.

We can also have multiple files specified using -f.

> This is really great for dev, staging and CI

![docker compose](./pics/dockercompose1.png)
![docker compose](./pics/dockercompose2.png)
![docker compose](./pics/dockercompose3.png)
![docker compose](./pics/dockercompose4.png)

### Why override?

![docker compose override](./pics/override1.png)
![docker compose override](./pics/override2.png)

In order to make sure one image is started before the other we use `depend on:` and specify the name container_name.

We can fire up docker compose using `docker-compose up -d`.

> We always should remember to check docker-machine on Windows and Mac.

## Docker Swarm

All We checked so far is single host docker. now we are going for multi docker host deployment. Single is bad because
We would only have a single point of failure.

* Docker swarm gives us Native Clustering for Docker
* Provides a unified interface to a pool of Docker hosts
* Fully integrated with machine and compose
* Serves standard docker API

![Docker swarm](./pics/swarm1.png)
![Docker swarm](./pics/swarm2.png)
![Docker swarm](./pics/swarm3.png)
