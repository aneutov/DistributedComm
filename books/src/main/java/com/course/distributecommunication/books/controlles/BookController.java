package com.course.distributecommunication.books.controlles;

import com.course.distributecommunication.books.dtos.BookDto;
import com.course.distributecommunication.books.models.Book;
import com.course.distributecommunication.books.messagemodels.BookAndAuthor;
import com.course.distributecommunication.books.queue.BookAndAuthorQueueSender;
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
import java.util.stream.Collectors;

@RestController
public class BookController {

  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  @Autowired private BookService bookService;
  @Autowired private BookAndAuthorQueueSender bookAndAuthorQueueSender;

  @GetMapping("/api/v1/books")
  public Collection<BookDto> books() {
    Collection<Book> books = bookService.getBooks();
    return books.stream().map(book ->
      new BookDto()
        .withId(book.getId())
        .withAuthorId(book.getAuthorId())
        .withPages(book.getPages())
        .withTitle(book.getTitle())
    ).collect(Collectors.toList());

  }

  @PostMapping("/api/v1/booksandauthors")
  public ResponseEntity addBook(@RequestBody BookAndAuthor bookAndAuthor) {
    Book newBook = new Book(bookAndAuthor.getId())
      .withAuthorId(bookAndAuthor.getAuthorId())
      .withPages(bookAndAuthor.getPages())
      .withTitle(bookAndAuthor.getTitle());

    boolean isNewlyAddedBook = bookService.addBook(newBook);

    if (isNewlyAddedBook) {
      bookAndAuthorQueueSender.send(bookAndAuthor);
      return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    } else {
      return new ResponseEntity(HttpStatus.OK);
    }
  }

}
