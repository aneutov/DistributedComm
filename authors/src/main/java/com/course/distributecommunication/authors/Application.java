package com.course.distributecommunication.authors;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class Application {
  @Value("${queue.exchange.name}")
  private String queueName;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Queue queue() {
    return new Queue(queueName, true);
  }
}
