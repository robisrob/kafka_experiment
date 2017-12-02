# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.swartenbroekx@gmail.com"
ENV PORT="8080"
ENV SERVER_PORT=$PORT
WORKDIR /app
COPY ./application .
RUN adduser -S app
USER app
CMD ./bin/application
