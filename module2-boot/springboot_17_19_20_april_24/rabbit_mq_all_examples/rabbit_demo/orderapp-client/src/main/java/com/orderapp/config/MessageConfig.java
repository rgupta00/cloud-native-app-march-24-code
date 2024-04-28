package com.orderapp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

}



