package com.spf.rabbitmq.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * created by shipengfei
 * on 2018/12/24, 15:05
 * motto: Saying and doing is two different things.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello-rabbitmq", true);
    }

}
