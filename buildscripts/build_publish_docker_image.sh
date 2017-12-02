cd $HOME/build/robisrob/kafka_experiment
mkdir docker_workdir
./gradlew :application:distTar
cp buildscripts/Dockerfile ./docker_workdir
tar -xf application/build/distributions/application.tar
cp application/build/distributions/application ./docker_workdir
cd docker_workdir
docker build -t robisrob/kafka-experiment:$TRAVIS_BUILD_NUMBER .
docker login -u=$HEROKU_USERNAME -p=$HEROKU_AUTH_TOKEN registry.heroku.com;
docker tag robisrob/kafka-experiment:$TRAVIS_BUILD_NUMBER registry.heroku.com/kafka-experiment/web;
docker push registry.heroku.com/partei/web;