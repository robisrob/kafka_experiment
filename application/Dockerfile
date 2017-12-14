# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.swartenbroekx@gmail.com"
WORKDIR /app
RUN adduser -S app
USER app
CMD ./kafka_experiment/bin/application
ADD ./application.tar .

