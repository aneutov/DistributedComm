package com.course.distributecommunication.frontend.services;

import com.course.distributecommunication.books.grpc.BookServiceGrpc;
import com.course.distributecommunication.books.grpc.GetBookResponse;
import com.course.distributecommunication.books.grpc.GetBooksRequest;
import com.course.distributecommunication.frontend.dtos.BookDTO;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class BooksConsumerService {

  public Collection<BookDTO> fetch() {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("books", 9090).usePlaintext().build();

    BookServiceGrpc.BookServiceBlockingStub stub = BookServiceGrpc.newBlockingStub(channel);

    Iterator<GetBookResponse> booksIterator = stub.getBooks(GetBooksRequest.newBuilder().build());

    List<BookDTO> books = new ArrayList<BookDTO>();
    booksIterator.forEachRemaining(book ->
      books.add(new BookDTO()
      .withId(book.getId())
      .withTitle(book.getTitle())
      .withAuthorId(book.getAuthorId())
      .withPages(book.getPages())));

    return books;
  }
}

