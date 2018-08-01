package com.caozeal.practice.rocketmq;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * <p>创建时间：2018/1/4 14:21
 * <p>com.caozeal.practice.rocketmq
 * @author caozhiyong
 * @version 1.0
 */
public class RocketMQListener implements MessageListenerConcurrently{

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        System.out.println("get data from rocketMQ:" + msgs);
        for (MessageExt message : msgs) {

            String msg = new String(message.getBody());
            System.out.println("msg data from rocketMQ:" + msg);
        }

        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }
}
