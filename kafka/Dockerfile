FROM openjdk:8-jre-alpine
WORKDIR /app
RUN mkdir logs && \
    apk update && apk add bash && apk add libc6-compat && apk add supervisor && \
    wget "http://apache.cu.be/kafka/1.0.0/kafka_2.11-1.0.0.tgz" && \
    tar xvzf kafka_2.11-1.0.0.tgz && rm kafka_2.11-1.0.0.tgz
COPY supervisord.conf /app/supervisord.conf
COPY server.properties /app/server.properties
CMD /usr/bin/supervisord -c /app/supervisord.conf

