package com.vanshika.JMStry1;
import javax.jms.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
  
@SpringBootApplication
@EnableJms
public class JmStry1Application  {
 
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
 
 
     
    public static void main(String[] args) {
        
        ConfigurableApplicationContext context = SpringApplication.run(JmStry1Application.class, args);
 
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
 
        System.out.println("Sending a JMS message.");
        
        jmsTemplate.convertAndSend("FirstQueue", "This is my first JMS Example");
    }
 
}