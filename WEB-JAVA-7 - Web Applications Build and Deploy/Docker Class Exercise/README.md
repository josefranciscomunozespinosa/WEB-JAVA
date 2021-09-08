# Docker Class Exercise - Hello World

## Creating your first Docker Image

### Step 1: Hello Docker World 
1. `git clone https://github.com/spring-guides/gs-spring-boot-docker.git`
2. Create a new git repository and copy the folder `gs-spring-boot-docker/complete` in to your new git project
4. Import the project into IntelliJ.
5. If you read the Readme.adoc file (from teh gs-spring-boot-docker imported project) you can follow the complete instructions to implement it from scrach. You should take the `Application.java` file from this folder and put it into the `src/` in your project. (But everithing is already done in the `complete` folder but with different message. Update it with your name in the `your_project/src/../Application.java`)
6. In your terminal, go to your project folder. Run from the command line:`./mvnw package && java -jar target/spring-boot-docker-complete-0.0.1-SNAPSHOT.jar`
7. Go to localhost:8080 to see your personaliced "Hello Docker World" message. In my case "Hola Jose Francisco. Bienvenido al mundo docker!!!"

### Step 2: Containerize It
1. Put the `Dockerfile` in this folder into your application.
2. Follow the instructions from [here](https://spring.io/guides/gs/spring-boot-docker/)
    - If you use Gradle, you can run it with the following command:
    ```
    docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .
    ```
    - If you use Maven, you can run it with the following command:
    ```
    docker build -t springio/gs-spring-boot-docker .
    ```
    - This command builds an image and tags it as springio/gs-spring-boot-docker.

3. Run on docker!
    ```
    docker run -p 8080:8080 -t springio/gs-spring-boot-docker
    ```
4. Check out your Docker World Application at http://localhost:8080.

Congratulations! You’ve just created a Docker container for a Spring Boot app! 

## Deploying your Docker Image to Heroku

1. Make sure you have a Heroku account and install the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install).
2. Create your docker image from the steps above (Creating your first Docker Image).
3. Create one file called `heroku.yml` in the same path than the Dockerfile
```
build:
  docker:
    web: Dockerfile
```
5. Deploy on Heroku. Copy and paste each command - one at a time.
```
heroku login
heroku container:login
heroku apps:create ${YOUR_APP_NAME}
heroku container:push web --app ${YOUR_APP_NAME}
heroku container:release web --app ${YOUR_APP_NAME}
```

To see your app, go to your heroku dashboard OR on the command line: `heroku open --app ${YOUR_APP_NAME}`
