package com.spf.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
 * created by shipengfei
 * on 2018/12/24, 16:49
 * motto: Saying and doing are two different things.
 */
@Component
public class KafkaReceiver {

    private static final Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = {"hello-kafka"})
    public void receive(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            logger.warn("kafka receive record = " + record + ", message = " + message);
        }
    }
}
