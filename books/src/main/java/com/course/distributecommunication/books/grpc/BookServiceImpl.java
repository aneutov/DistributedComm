package com.course.distributecommunication.books.grpc;

import com.course.distributecommunication.books.models.Book;
import com.course.distributecommunication.books.services.BookDbStubService;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@GrpcService
public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {
  private @Autowired
  BookDbStubService bookDbStubService;

  @Override
  public void getBooks(GetBooksRequest request, StreamObserver<GetBookResponse> responseObserver) {
    Collection<Book> books = bookDbStubService.getBooks();

    for (Book book:books) {
      GetBookResponse response = GetBookResponse.newBuilder()
        .setId(book.getId())
        .setAuthorId(book.getAuthorId())
        .setTitle(book.getTitle())
        .setPages(book.getPages())
        .build();
      responseObserver.onNext(response);
    }
    responseObserver.onCompleted();
  }
}
