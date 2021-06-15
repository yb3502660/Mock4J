package com.bingo.consumer;

import com.bingo.entity.base.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:yaobin
 * @date:2021/6/15,14:15
 */

@Component
public class RabbitConsumer {
    
    //直连
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.SIMPLE_QUEUE_NAME)
    public void simpleListener(String context){
        System.out.println("rabbit receiver: "+context);
    }
    
    //work1  多个consumer 负载均衡
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.WORK_QUEUE_NAME)
    public void workListener(String context){
        System.out.println("rabbit  workListener1 receiver: "+context);

    }

    //work2
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.WORK_QUEUE_NAME)
    public void workListener2(String context){
        System.out.println("rabbit  workListener2 receiver: "+context);

    }
    
    
    //发布/订阅1
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.PUBLISH_SUBSCRIBE_FIRST_QUEUE_NAME)
    public void pubsub1(String context){
        System.out.println("rabbit  pubsub1 receiver: "+context);

    }

    //发布/订阅2
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.PUBLISH_SUBSCRIBE_SECOND_QUEUE_NAME)
    public void pubsub2(String context){
        System.out.println("rabbit  pubsub2 receiver: "+context);

    }
    
    //路由1
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.ROUTING_FIRST_QUEUE_NAME)
    public void routing(String context){
        System.out.println("rabbit  routing1 receiver: "+context);

    }

    //路由2
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.ROUTING_SECOND_QUEUE_NAME)
    public void routing2(String context){
        System.out.println("rabbit  routing2 receiver: "+context);

    }
    
    //路由3
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.ROUTING_THIRD_QUEUE_NAME)
    public void routing3(String context){
        System.out.println("rabbit  routing3 receiver: "+context);

    }
    
    //topic1
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.TOPICS_FIRST_QUEUE_NAME)
    public void topic1(String context){
        System.out.println("rabbit  topic1 receiver: "+context);
    }
      //topic2
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.TOPICS_SECOND_QUEUE_NAME)
    public void topic2(String context){
        System.out.println("rabbit  topic2 receiver: "+context);
    }
      //topic3
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.TOPICS_THIRD_QUEUE_NAME)
    public void topic3(String context){
        System.out.println("rabbit  topic3 receiver: "+context);
    }

    //headers 1
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.HEADER_FIRST_QUEUE_NAME)
    public void headers1(String context){
        System.out.println("rabbit  headers1 receiver: "+context);
    }

    //headers 2
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.HEADER_SECOND_QUEUE_NAME)
    public void headers2(String context){
        System.out.println("rabbit  headers2 receiver: "+context);
    }
    
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.RPC_QUEUE_NAME)
    public String rpc(String context){
        System.out.println("rabbit rpc queue receiver: " + context);
        return "copy that!";
    }


}
