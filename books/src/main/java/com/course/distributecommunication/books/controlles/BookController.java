package com.course.distributecommunication.books.controlles;

import com.course.distributecommunication.books.models.Book;
import com.course.distributecommunication.books.models.BookAndAuthor;
import com.course.distributecommunication.books.queue.QueueSender;
import com.course.distributecommunication.books.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  @Autowired private BookService bookService;
  @Autowired private QueueSender queueSender;

  @GetMapping("/api/v1/books")
  public Collection<Book> books() {
    return bookService.getBooks();
  }

  @PostMapping("/api/v1/books")
  public ResponseEntity addBook(@RequestBody BookAndAuthor bookAndAuthor) {
    Book newBook = new Book(bookAndAuthor.getId())
      .withAuthorId(bookAndAuthor.getAuthorId())
      .withPages(bookAndAuthor.getPages())
      .withTitle(bookAndAuthor.getTitle());

    boolean isNewlyAddedBook = bookService.addBook(newBook);

    if (isNewlyAddedBook) {
      queueSender.send(bookAndAuthor);
      return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    } else {
      return new ResponseEntity(HttpStatus.OK);
    }
  }

}
