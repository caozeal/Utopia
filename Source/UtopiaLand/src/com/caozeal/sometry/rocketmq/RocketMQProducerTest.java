package com.caozeal.sometry.rocketmq;

import org.apache.rocketmq.common.message.Message;

/**
 * <p>创建时间：2018/1/4 14:57
 * <p>com.caozeal.sometry.rocketmq
 * @author caozhiyong
 * @version 1.0
 */
public class RocketMQProducerTest {

    public static void main(String[] args) {

        String mqNameServer = "172.16.192.116:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();


        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = new Message();
            message.setBody(("I send message to RocketMQ " + i).getBytes());
            mqProducer.send(message);
        }



    }
}
