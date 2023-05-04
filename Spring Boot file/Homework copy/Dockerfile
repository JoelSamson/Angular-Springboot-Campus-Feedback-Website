FROM openjdk:17
CMD ["mvm clean install"]
COPY target/hw3.jar .
EXPOSE 8080
CMD ["java","-jar","hw3.jar"]