package com.course.distributecommunication.books;

import com.course.distributecommunication.books.grpc.BookServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws InterruptedException, IOException {
    SpringApplication.run(Application.class, args);
    Server server = ServerBuilder.forPort(9090).addService(new BookServiceImpl()).build();

    server.start();
    server.awaitTermination();
  }

}
