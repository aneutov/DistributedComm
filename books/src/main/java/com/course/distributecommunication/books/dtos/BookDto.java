package com.course.distributecommunication.books.dtos;

public class BookDto {
  private int id;
  private String title;
  private int pages;
  private int authorId;

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
  public void setAuthorId(int authorId) { this.authorId = authorId; }

  public BookDto withId(int id) {
    this.setId(id);
    return this;
  }

  public BookDto withTitle(String title) {
    this.setTitle(title);
    return this;
  }

  public BookDto withAuthorId(int author) {
    this.setAuthorId(author);
    return this;
  }

  public BookDto withPages(int pages) {
    this.setPages(pages);
    return this;
  }
}
