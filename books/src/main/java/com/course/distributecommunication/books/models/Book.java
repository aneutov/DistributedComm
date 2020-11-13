package com.course.distributecommunication.books.models;

import java.util.Objects;

public class Book {
  private int id;
  private String title;
  private int pages;
  private int authorId;

  public Book(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
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

  public void setAuthorId(int autorId) {
    this.authorId = autorId;
  }

  public Book withTitle(String title) {
    this.setTitle(title);
    return this;
  }

  public Book withAuthorId(int author) {
    this.setAuthorId(author);
    return this;
  }

  public Book withPages(int pages) {
    this.setPages(pages);
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    }
    if (!(obj instanceof Book)) {
      return false;
    }
    Book elseBook = (Book) obj;
    if ((elseBook.id == this.id)
      && (elseBook.title.equals(this.title))
      && (elseBook.pages == this.pages)
      && (elseBook.authorId == this.authorId)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.pages, this.authorId);
  }
}
