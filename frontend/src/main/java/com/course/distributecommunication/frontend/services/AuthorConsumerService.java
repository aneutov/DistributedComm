package com.course.distributecommunication.frontend.services;
import com.course.distributecommunication.frontend.dtos.AuthorDto;

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
public class AuthorConsumerService {
  private static final Logger logger = LoggerFactory.getLogger(AuthorConsumerService.class);
  @Autowired
  RestTemplate restTemplate;
  @Value("${api.externalservices.authors.url}")
  private String apiUrlRoot;

  public Collection<AuthorDto> fetch() {
    try {
      ResponseEntity<AuthorDto[]> entity = restTemplate.getForEntity(apiUrlRoot + "/authors", AuthorDto[].class);
      return Arrays.asList(entity.getBody());
    } catch (Exception ex){
      return null;
    }
  }

}