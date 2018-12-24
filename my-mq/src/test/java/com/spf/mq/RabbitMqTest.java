package com.spf.mq;

import com.spf.dto.MessageHello;
import com.spf.rabbitmq.provider.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/*
 * created by shipengfei
 * on 2018/12/24, 16:40
 * motto: Saying and doing are two different things.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private RabbitMqSender sender;

    @Test
    public void rabbitMqHelloSenderTest(){
        try{
            for(int i=0; i<5; i++){
                MessageHello message = new MessageHello(System.currentTimeMillis(), UUID.randomUUID().toString(), new Date());
                sender.sendHello(message);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
