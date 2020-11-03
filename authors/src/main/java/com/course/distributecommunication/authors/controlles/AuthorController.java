package com.course.distributecommunication.authors.controlles;

import com.course.distributecommunication.authors.models.Author;
import com.course.distributecommunication.authors.services.AuthorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AuthorController {

  private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
  private @Autowired
  AuthorService authorService;

  @GetMapping("/api/v1/authors")
  public Collection<Author> authors() {
    return authorService.getAuthors();
  }

}
