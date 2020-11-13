package com.course.distributecommunication.frontend.services;
import com.course.distributecommunication.frontend.dtos.BookDto;

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

  public Collection<BookDto> fetch() {
    try {
      ResponseEntity<BookDto[]> entity = restTemplate.getForEntity(apiUrlRoot + "/books", BookDto[].class);
      return Arrays.asList(entity.getBody());
    } catch (Exception ex){
      return null;
    }
  }

}
