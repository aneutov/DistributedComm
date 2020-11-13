package com.course.distributecommunication.frontend.dtos;

public class BookDto
{
    private int id;
    private String title;
    private int pages;
    private int authorId;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

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

}
