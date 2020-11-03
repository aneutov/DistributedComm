package com.course.distributecommunication.frontend.services;

import com.course.distributecommunication.authors.grpc.AuthorServiceGrpc;
import com.course.distributecommunication.authors.grpc.GetAuthorResponse;
import com.course.distributecommunication.authors.grpc.GetAuthorsRequest;
import com.course.distributecommunication.frontend.dtos.AuthorDTO;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class AuthorsConsumerService {

  public Collection<AuthorDTO> fetch() {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("authors", 9090).usePlaintext().build();

    AuthorServiceGrpc.AuthorServiceBlockingStub stub = AuthorServiceGrpc.newBlockingStub(channel);

    Iterator<GetAuthorResponse> authorsIterator = stub.getAuthors(GetAuthorsRequest.newBuilder().build());

    List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
    authorsIterator.forEachRemaining(author ->
      authors.add(new AuthorDTO()
        .withId(author.getId())
        .withFirstName(author.getFirstName())
        .withLastName(author.getLastName())));

    return authors;
  }
}

