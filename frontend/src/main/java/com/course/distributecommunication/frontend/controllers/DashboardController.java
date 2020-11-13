package com.course.distributecommunication.frontend.controllers;

import com.course.distributecommunication.frontend.dtos.AuthorDto;
import com.course.distributecommunication.frontend.dtos.BookDto;
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

    Collection<BookDto> bookDtos = bookConsumerService.fetch();
    if  (Objects.nonNull(bookDtos)) result.put("bookDtos", bookDtos);

    Collection<AuthorDto> authorDtos = authorConsumerService.fetch();
    if  (Objects.nonNull(authorDtos)) result.put("authorDtos", authorDtos);

    return result;
  }

}
