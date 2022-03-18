package home.beav.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test_topic", groupId = "local-test-grp-01")
    public void consume(String message) {
        log.info("Consumed message : {}", message);
    }

}
