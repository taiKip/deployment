FROM openjdk:17-alpine
WORKDIR /app
COPY target/githubactions.jar  githubactions.jar
EXPOSE 8000
CMD ["java","-jar","githubactions.jar"]