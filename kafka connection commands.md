Docker terminal flow:

1. connect to kafka terminal within docker  - docker container exec -it cloud-kafka-1-1  /bin/bash

2. start running commands - kafka-topics --bootstrap-server localhost:29092 --list


Run docker exec on every command:

docker exec -it cloud-kafka-1-1 kafka-topics --create --topic my-topic --partitions 1 --replication-factor 1 --bootstrap-server local
host:29092



https://medium.com/@clasikas/kafka-in-docker-container-and-command-line-67bb0eb2d