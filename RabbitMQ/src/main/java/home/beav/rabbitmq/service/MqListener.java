package home.beav.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MqListener {

    @RabbitListener(queues = "${mq.queue}", concurrency = "${mq.threadCnt}")
    public void receiveMessage(final Message message) {
        log.info("message : " + new String(message.getBody()));
    }

}
