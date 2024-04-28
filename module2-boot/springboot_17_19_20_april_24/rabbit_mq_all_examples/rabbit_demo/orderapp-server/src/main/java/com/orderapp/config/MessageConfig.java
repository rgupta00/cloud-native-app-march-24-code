package com.orderapp.config;

import jakarta.servlet.http.PushBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MessageConfig {
    public static final String ORDERAPP_QUEUE = "orderapp_queue";
    public static final String ORDERAPP_EXCHANGE = "orderapp_exhange";
    public static final String ORDERAPP_ROUTINGKEY = "orderapp_routingkey";

    @Bean
    public Queue queue(){
        return new Queue(ORDERAPP_QUEUE, true);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(ORDERAPP_EXCHANGE);
    }
    //bind both
//    @Bean
//    public Binding binding(Queue queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(queue).to(topicExchange).with(ORDERAPP_ROUTINGKEY);
//    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with(ORDERAPP_ROUTINGKEY);
    }
    @Bean
    public  MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    //RabbitTemplate
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
//    public static final String ORDERAPP_QUEUE = "orderapp_queue";
//    public static final String ORDERAPP_EXCHANGE = "orderapp_exhange";
//    public static final String ORDERAPP_ROUTINGKEY = "orderapp_routingkey";
//
//    //Queue
//    @Bean
//    public Queue queue(){
//        return new Queue(ORDERAPP_QUEUE);
//    }
//    //topicEx
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange(ORDERAPP_EXCHANGE);
//    }
//    //binding
//    public Binding binding(){
//        return BindingBuilder.bind(queue()).to(topicExchange()).with(ORDERAPP_ROUTINGKEY);
//    }
//    //message converter
//    @Bean
//    public MessageConverter messageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//    //RabbitMqTemple
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
//        RabbitTemplate template=new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }

}



