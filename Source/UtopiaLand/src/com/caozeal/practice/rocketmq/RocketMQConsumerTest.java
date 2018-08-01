package com.caozeal.practice.rocketmq;

/**
 * <p>创建时间：2018/1/4 14:57
 * <p>com.caozeal.practice.rocketmq
 * @author caozhiyong
 * @version 1.0
 */
public class RocketMQConsumerTest {

    public static void main(String[] args) {


        String mqNameServer = "172.16.192.116:9876";
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String consumerMqGroupName = "CONSUMER-MQ-GROUP";
        RocketMQListener mqListener = new RocketMQListener();
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, mqNameServer, consumerMqGroupName, mqTopics);
        mqConsumer.init();


//        try {
//            Thread.sleep(1000 * 60L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
