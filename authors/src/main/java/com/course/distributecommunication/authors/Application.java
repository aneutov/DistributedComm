package com.course.distributecommunication.authors;

import com.course.distributecommunication.authors.grpc.AuthorServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(Application.class, args);

    Server server = ServerBuilder.forPort(9090).addService(new AuthorServiceImpl()).build();

    server.start();
    server.awaitTermination();
  }

}
