package com.spf.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Component;

/*
 * created by shipengfei
 * on 2018/12/24, 16:33
 * motto: Saying and doing is two different things.
 */
@Component
@RabbitListener(queues = {"hello-rabbitmq"})
public class RabbitMqReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

    @RabbitHandler
    public void receive(String hello){
        logger.warn("rabbitmq receive is " + hello);
    }
}
