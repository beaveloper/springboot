package home.beav.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MqSender {

    private final RabbitTemplate rabbitTemplate;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routingKey}")
    private String routingKey;

    public void sendMsg(String msg) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        } catch (Exception e) {
            log.error("message send fail, {}", e.getMessage());
        }
    }
}
