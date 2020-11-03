package com.course.distributecommunication.books.controlles;

import com.course.distributecommunication.books.models.Book;
import com.course.distributecommunication.books.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  private @Autowired
  BookService bookService;

  @GetMapping("/api/v1/books")
  public Collection<Book> books() {
    return bookService.getBooks();
  }

}
