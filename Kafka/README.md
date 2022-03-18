# springboot kafka

## kafka docker run cmd

1. docker-compose.yml -> docker-compose -f docker-compose.yml up -d









### test topic 생성
sh kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
### topic list 조회
sh kafka-topics.sh --bootstrap-server localhost:9092 --list
### producer
sh kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test
### consumer
sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
### group 조회
sh kafka-consumer-groups.sh --list --bootstrap-server localhost:9092
### 컨슈머 상태, 오프셋 조회
sh kafka-consumer-groups.sh --describe --group console-consumer-32871 --bootstrap-server localhost:9092
