## kafka 실행

### 1. zookeeper
```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### 2. kafka server
```
bin/kafka-server-start.sh config/server.properties
bin/kafka-server-start.sh config/server1.properties
bin/kafka-server-start.sh config/server2.properties
```

### 3. 토픽 생성
```
bin/kafka-topics.sh --create --topic topic5 --bootstrap-server localhost:9092 --partitions 3 --replication-factor 2
```
