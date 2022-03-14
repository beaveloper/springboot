package home.beav.rabbitmq.rest;

import home.beav.rabbitmq.service.MqSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RabbitRestController {

    private final MqSender mqSender;

    @GetMapping("/send/sample")
    public String sendSampleMsg(String msg) {

        mqSender.sendMsg(msg);

        return "success";
    }

}
