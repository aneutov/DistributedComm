package com.course.distributecommunication.frontend.controllers;

import com.course.distributecommunication.frontend.models.Author;
import com.course.distributecommunication.frontend.models.Book;
import com.course.distributecommunication.frontend.services.AuthorConsumerService;
import com.course.distributecommunication.frontend.services.BookConsumerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class DashboardController {

  private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
  private @Autowired
  BookConsumerService bookConsumerService;
  private @Autowired
  AuthorConsumerService authorConsumerService;

  @GetMapping("/api/v1/dashboard")
  public HashMap dashboard() {
    HashMap result = new HashMap();

    Collection<Book> books = bookConsumerService.fetch();
    if  (Objects.nonNull(books)) result.put("books", books);

    Collection<Author> authors = authorConsumerService.fetch();
    if  (Objects.nonNull(authors)) result.put("authors", authors);

    return result;
  }

}
