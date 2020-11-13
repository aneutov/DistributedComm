package com.course.distributecommunication.authors.messagemodels;

import java.io.Serializable;

public class BookAndAuthor implements Serializable {
  private int id;
  private String title;
  private int pages;
  private int authorId;
  private String firstName;
  private String lastName;


  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public int getPages() {
    return pages;
  }
  public void setPages(int pages) {
    this.pages = pages;
  }

  public int getAuthorId() {
    return authorId;
  }
  public void setAuthorId(int authorId) {
    this.authorId = authorId;
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

  public BookAndAuthor withTitle(String title) {
    this.setTitle(title);
    return this;
  }

  public BookAndAuthor withPages(int pages) {
    this.setPages(pages);
    return this;
  }

  public BookAndAuthor withAuthorId(int author) {
    this.setAuthorId(author);
    return this;
  }

  public BookAndAuthor withAuthorFirstName(String firstName) {
    this.setFirstName(firstName);
    return this;
  }

  public BookAndAuthor withAuthorLastName(String lastName) {
    this.setLastName(lastName);
    return this;
  }

}
