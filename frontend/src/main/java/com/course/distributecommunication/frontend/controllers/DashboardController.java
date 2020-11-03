package com.course.distributecommunication.frontend.controllers;

import com.course.distributecommunication.frontend.dtos.AuthorDTO;
import com.course.distributecommunication.frontend.dtos.BookDTO;
import com.course.distributecommunication.frontend.services.AuthorsConsumerService;
import com.course.distributecommunication.frontend.services.BooksConsumerService;

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
  private @Autowired BooksConsumerService booksConsumerService;
  private @Autowired AuthorsConsumerService authorsConsumerService;

  @GetMapping("/api/v1/dashboard")
  public HashMap dashboard() {
    HashMap result = new HashMap();

    Collection<BookDTO> books = booksConsumerService.fetch();
    if (Objects.nonNull(books))
      result.put("books", books);

    Collection<AuthorDTO> authors = authorsConsumerService.fetch();
    if (Objects.nonNull(authors))
      result.put("authors", authors);

    return result;
  }
}
