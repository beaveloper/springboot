package home.beav.kafka.controller;

import home.beav.kafka.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/kafka/send")
    public String sendKafka(String msg) {
        producer.sendMessage(msg);
        return "success";
    }

}
