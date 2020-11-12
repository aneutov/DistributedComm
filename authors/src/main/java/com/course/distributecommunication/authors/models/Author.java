package com.course.distributecommunication.authors.models;

import java.util.Objects;

public class Author
{
    private int id;
    private String firstName;
    private String lastName;

    public Author(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public Author withFirstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public Author withLastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }


  @Override
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    }
    if (!(obj instanceof Author)) {
      return false;
    }
    Author elseAuthor = (Author) obj;
    if ((elseAuthor.id == this.id)
      && (elseAuthor.lastName.equals(this.lastName))
      && (elseAuthor.firstName.equals(this.firstName))) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
      return  Objects.hash(this.id,this.firstName,this.lastName);
  }
}
