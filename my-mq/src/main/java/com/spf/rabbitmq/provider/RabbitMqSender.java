package com.spf.rabbitmq.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spf.dto.MessageHello;
import com.spf.rabbitmq.conf.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

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

        // 默认direct模式，单播
        //rabbitTemplate.convertAndSend(RabbitConfig.MY_DIRECT_QUEUE, message);
        rabbitTemplate.convertAndSend(RabbitConfig.MY_DIRECT_EXCHANGE,RabbitConfig.MY_DIRECT_QUEUE, message);

        // topic模式，多播
        rabbitTemplate.convertAndSend(RabbitConfig.MY_TOPIC_EXCHANGE, RabbitConfig.MY_TOPIC_QUEUE, message);

        logger.warn("rabbitmq send message = " + message);
    }
}
