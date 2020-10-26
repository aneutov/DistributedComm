package com.course.distributecommunication.frontend.services;
import com.course.distributecommunication.frontend.models.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;

@Component
public class BookConsumerService {
  private static final Logger logger = LoggerFactory.getLogger(BookConsumerService.class);
  @Autowired
  RestTemplate restTemplate;
  @Value("${api.externalservices.books.url}")
  private String apiUrlRoot;

  public Collection<Book> fetch() {
    try {
      ResponseEntity<Book[]> entity = restTemplate.getForEntity(apiUrlRoot + "/books", Book[].class);
      return Arrays.asList(entity.getBody());
    } catch (Exception ex){
      return null;
    }
  }

}
