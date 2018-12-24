package com.spf.rabbitmq.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spf.dto.MessageHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * created by shipengfei
 * on 2018/12/24, 16:33
 * motto: Saying and doing is two different things.
 */
@Component
public class RabbitMqSender {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHello(MessageHello dto){
        ObjectMapper toJson = new ObjectMapper();
        String message = "";
        try{
            message = toJson.writeValueAsString(dto);
        }catch (Exception e){
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend("hello-rabbitmq", message);
        logger.warn("rabbitmq send message = " + message);
    }
}
