package com.spf.rabbitmq.conf;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * created by shipengfei
 * on 2018/12/24, 15:05
 * motto: Saying and doing are two different things.
 */
@Configuration
public class RabbitConfig {

    public static final String MY_DIRECT_EXCHANGE = "my_direct_exchange";
    public static final String MY_TOPIC_EXCHANGE = "my_topic_exchange";
    public static final String MY_FANOUT_EXCHANGE = "my_fanout_exchange";

    public static final String MY_DIRECT_QUEUE = "my.direct.queue";
    public static final String MY_TOPIC_QUEUE = "my.topic.queue";
    //public static final String MY_FANOUT_QUEUE = "my_fanout_queue";

    /**
     * create my exchange: direct, topic, fanout
     */
    @Bean
    public DirectExchange myDirectExchange(){
        return new DirectExchange(MY_DIRECT_EXCHANGE);
    }
    @Bean
    public TopicExchange myTopicExchange(){
        return new TopicExchange(MY_TOPIC_EXCHANGE);
    }
    /*@Bean
    public FanoutExchange myFanoutExchange(){
        return new FanoutExchange(MY_FANOUT_EXCHANGE);
    }*/

    /**
     * create my queue: direct, topic, fanout
     */
    @Bean
    public Queue myDirectQueue(){
        return new Queue(MY_DIRECT_QUEUE, true);
    }
    @Bean
    public Queue myTopicQueue(){
        return new Queue(MY_TOPIC_QUEUE);
    }
    /*@Bean
    public Queue myFanoutQueue(){
        return new Queue(MY_FANOUT_QUEUE);
    }*/

    /**
     * binding queues to exchanges
     */
    @Bean
    public Binding bindingQueueToDirectExchange(Queue myDirectQueue, DirectExchange myDirectExchange){
        return BindingBuilder.bind(myDirectQueue).to(myDirectExchange).with(MY_DIRECT_QUEUE);
    }
    @Bean
    public Binding bindingQueueToTopicExchange(Queue myTopicQueue, TopicExchange myTopicExchange){
        return BindingBuilder.bind(myTopicQueue).to(myTopicExchange).with("my.topic.#");
    }
    /*@Bean
    public Binding bindingQueueToFanoutExchange(Queue myFanoutQueue, TopicExchange myFanoutExchange){
        return BindingBuilder.bind(myFanoutQueue).to(myFanoutExchange).with(MY_FANOUT_QUEUE);
    }*/

}
