package com.course.distributecommunication.authors.queue;

import com.course.distributecommunication.authors.models.Author;
import com.course.distributecommunication.authors.models.BookAndAuthor;
import com.course.distributecommunication.authors.services.AuthorService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
  @Autowired private AuthorService authorService;

  @RabbitListener(queues = "messageQueue")
  public void receive(String bookAndAuthorString) {
    try {
      BookAndAuthor bookAndAuthor = new ObjectMapper().readValue(bookAndAuthorString, BookAndAuthor.class);
      Author newAuthor = new Author(bookAndAuthor.getAuthorId())
        .withFirstName(bookAndAuthor.getFirstName())
        .withLastName(bookAndAuthor.getLastName());

      authorService.addAuthor(newAuthor);
    } catch (Exception ex) {}
  }
}
