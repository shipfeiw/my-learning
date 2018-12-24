package com.spf.kafka.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spf.dto.MessageHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/*
 * created by shipengfei
 * on 2018/12/24, 16:49
 * motto: Saying and doing are two different things.
 */
@Component
public class KafkaSender {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendHello(MessageHello dto){
        ObjectMapper toJson = new ObjectMapper();
        String message = "";
        try {
            message = toJson.writeValueAsString(dto);
        } catch (Exception e){
            e.printStackTrace();
        }
        kafkaTemplate.send("hello-kafka", message);
        logger.warn("kafka send message = " + message);
    }
}
