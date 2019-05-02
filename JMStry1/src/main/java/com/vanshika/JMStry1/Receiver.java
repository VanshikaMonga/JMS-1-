package com.vanshika.JMStry1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
 
@Component
public class Receiver {
  
    @JmsListener(destination = "FirstQueue")
    public void receiveMessage(String msg) {
        System.out.println("Received :" + msg);
    }
  
}