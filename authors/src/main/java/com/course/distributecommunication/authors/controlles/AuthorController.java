package com.course.distributecommunication.authors.controlles;

import com.course.distributecommunication.authors.dtos.AuthorDto;
import com.course.distributecommunication.authors.models.Author;
import com.course.distributecommunication.authors.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

  private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
  @Autowired
  private AuthorService authorService;

  @GetMapping("/api/v1/authors")
  public Collection<AuthorDto> authors() {
    Collection<Author> authors = authorService.getAuthors();
    return authors.stream().map(author ->
      new AuthorDto()
        .withId(author.getId())
        .withFirstName(author.getFirstName())
        .withLastName(author.getLastName())
    ).collect(Collectors.toList());
  }

}
