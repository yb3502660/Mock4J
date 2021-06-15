package com.bingo.config;

import com.bingo.entity.base.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:yaobin
 * @date:2021/6/15,14:13
 */

@Configuration
public class RabbitConfig {


    //直连queue
    @Bean
    public Queue simpleQueue() {
        return new Queue(RabbitConstant.SIMPLE_QUEUE_NAME);
    }

    //work queue
    @Bean
    public Queue workQueue() {
        return new Queue(RabbitConstant.WORK_QUEUE_NAME);
    }


    //publish/subscribe 模式 queue1
    @Bean
    public Queue pubsubQueueFirst() {
        return new Queue(RabbitConstant.PUBLISH_SUBSCRIBE_FIRST_QUEUE_NAME);
    }

    //publish/subscribe 模式 queue2
    @Bean
    public Queue pubsubQueueSecond() {
        return new Queue(RabbitConstant.PUBLISH_SUBSCRIBE_SECOND_QUEUE_NAME);
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        // 创建fanout类型交换机，表示与此交换机会将消息发送给所有绑定的队列
        return new FanoutExchange(RabbitConstant.PUBLISH_SUBSCRIBE_EXCHANGE_NAME);
    }

    @Bean
    public Binding pubsubQueueFirstBindFanoutExchange() {
        // 队列一绑定交换机

        return BindingBuilder.bind(pubsubQueueFirst()).to(fanoutExchange());
    }

    @Bean
    public Binding pubsubQueueSecondBindFanoutExchange() {
        // 队列二绑定交换机
        return BindingBuilder.bind(pubsubQueueSecond()).to(fanoutExchange());
    }


    //路由模式 queue1
    @Bean
    public Queue routingQueue1() {
        return new Queue(RabbitConstant.ROUTING_FIRST_QUEUE_NAME);
    }

    //路由模式 queue2
    @Bean
    public Queue routingQueue2() {
        return new Queue(RabbitConstant.ROUTING_SECOND_QUEUE_NAME);
    }

    //路由模式 queue3
    @Bean
    public Queue routingQueue3() {
        return new Queue(RabbitConstant.ROUTING_THIRD_QUEUE_NAME);
    }

    //直连交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitConstant.ROUTING_EXCHANGE_NAME);
    }

    //路由模式-绑定 queue1
    @Bean
    public Binding routingBindDirectExchange1() {
        //路由模式绑定,需要唯一的key
        return BindingBuilder.bind(routingQueue1()).to(directExchange()).with(RabbitConstant.ROUTING_FIRST_QUEUE_ROUTING_KEY_NAME);
    }

    //路由模式-绑定 queue2
    @Bean
    public Binding routingBindDirectExchange2() {
        //路由模式绑定,需要唯一的key
        return BindingBuilder.bind(routingQueue2()).to(directExchange()).with(RabbitConstant.ROUTING_SECOND_QUEUE_ROUTING_KEY_NAME);
    }

    //路由模式-绑定 queue1
    @Bean
    public Binding routingBindDirectExchange3() {
        //路由模式绑定,需要唯一的key
        return BindingBuilder.bind(routingQueue3()).to(directExchange()).with(RabbitConstant.ROUTING_THIRD_QUEUE_ROUTING_KEY_NAME);
    }

    //topic模式 queue1
    @Bean
    public Queue topicQueue1() {
        return new Queue(RabbitConstant.TOPICS_FIRST_QUEUE_NAME);
    }

    //topic模式 queue2
    @Bean
    public Queue topicQueue2() {
        return new Queue(RabbitConstant.TOPICS_SECOND_QUEUE_NAME);
    }

    //topic模式 queue3
    @Bean
    public Queue topicQueue3() {
        return new Queue(RabbitConstant.TOPICS_THIRD_QUEUE_NAME);
    }

    //topic交换机
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitConstant.TOPICS_EXCHANGE_NAME);
    }

    //topic 绑定1
    @Bean
    public Binding topicBinding1() {
        // 队列一绑定topic类型交换机，并设置 routing_key 通配符为 #.first.#
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(RabbitConstant.TOPICS_ROUTING_KEY_FIRST_WILDCARD);
    }


    //topic 绑定2
    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(RabbitConstant.TOPICS_ROUTING_KEY_SECOND_WILDCARD);
    }

    //topic 绑定3
    @Bean
    public Binding topicBinding3() {
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with(RabbitConstant.TOPICS_ROUTING_KEY_THRID_WILDCARD);
    }

    //header模式 queue1
    @Bean
    public Queue headerQueue1() {
        return new Queue(RabbitConstant.HEADER_FIRST_QUEUE_NAME);
    }

    //header模式 queue2
    @Bean
    public Queue headerQueue2() {
        return new Queue(RabbitConstant.HEADER_SECOND_QUEUE_NAME);
    }

    //header exchange
    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(RabbitConstant.HEADER_EXCHANGE_NAME);
    }

    //header 绑定1
    @Bean
    public Binding headerBinding1() {
        Map<String, Object> map = new HashMap<>();
        map.put("matchAll", "YES");
        map.put("hello", "world");
        return BindingBuilder.bind(headerQueue1()).to(headersExchange()).whereAll(map).match();
    }

    //header 绑定2
    @Bean
    public Binding headerBinding2() {
        Map<String, Object> map = new HashMap<>();
        map.put("matchAll", "NO");
        map.put("hello", "world");
        return BindingBuilder.bind(headerQueue2()).to(headersExchange()).whereAny(map).match();
    }
    
    //rpc 模式
    @Bean
    public Queue rpcQueue(){
        return new Queue(RabbitConstant.RPC_QUEUE_NAME);
    }

}
