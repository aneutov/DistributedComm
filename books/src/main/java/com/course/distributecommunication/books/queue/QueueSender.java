package com.course.distributecommunication.books.queue;

import com.course.distributecommunication.books.models.BookAndAuthor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.amqp.core.Queue;

@Component
public class QueueSender {
  @Autowired private RabbitTemplate rabbitTemplate;
  @Autowired private Queue queue;

  public void send(BookAndAuthor bookAndAuthor) {
    try {
      rabbitTemplate.convertAndSend(this.queue.getName(),
        new ObjectMapper().writeValueAsString(bookAndAuthor));
    } catch (Exception ex)
    { }
  }

}
