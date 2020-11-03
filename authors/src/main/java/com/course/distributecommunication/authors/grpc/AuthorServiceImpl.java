package com.course.distributecommunication.authors.grpc;

import com.course.distributecommunication.authors.models.Author;
import com.course.distributecommunication.authors.services.AuthorDbStubService;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@GrpcService
public class AuthorServiceImpl extends AuthorServiceGrpc.AuthorServiceImplBase {
  private @Autowired
  AuthorDbStubService authorDbStubService;

  @Override
  public void getAuthors(GetAuthorsRequest request, StreamObserver<GetAuthorResponse> responseObserver) {
    Collection<Author> authors = authorDbStubService.getAuthors();

    for (Author author : authors) {
      GetAuthorResponse response =
        GetAuthorResponse.newBuilder().setId(author.getId()).setFirstName(author.getFirstName()).setLastName(author.getLastName()).build();
      responseObserver.onNext(response);
    }
    responseObserver.onCompleted();
  }
}
