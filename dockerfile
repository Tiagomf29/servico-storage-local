FROM openjdk:17-alpine

COPY target/projeto-storage-local-1.jar /projeto-storage-local.jar

WORKDIR /storage

EXPOSE 8080

VOLUME /app/pdfs

CMD ["java","-jar","/projeto-storage-local.jar"]