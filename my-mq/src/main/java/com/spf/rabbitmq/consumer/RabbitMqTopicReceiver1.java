package com.spf.rabbitmq.consumer;

import com.spf.rabbitmq.conf.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * created by shipengfei
 * on 2018/12/24, 16:33
 * motto: Saying and doing is two different things.
 */
@Component
@RabbitListener(queues = {RabbitConfig.MY_TOPIC_QUEUE})
public class RabbitMqTopicReceiver1 {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqTopicReceiver1.class);

    @RabbitHandler
    public void receive(String hello){
        logger.warn("topic receive1 is " + hello);
    }
}
