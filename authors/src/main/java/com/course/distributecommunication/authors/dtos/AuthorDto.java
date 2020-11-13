package com.course.distributecommunication.authors.dtos;

public class AuthorDto {
  private int id;
  private String firstName;
  private String lastName;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public AuthorDto withId(int id) {
    this.setId(id);
    return this;
  }

  public AuthorDto withFirstName(String firstName) {
    this.setFirstName(firstName);
    return this;
  }

  public AuthorDto withLastName(String lastName) {
    this.setLastName(lastName);
    return this;
  }

}
