package com.practicecode.amazonviewer.model;

import java.util.Date;

public class Publication {
    private String title;
    private Date editionDate;
    private String editorial;
    private String author;

    public Publication(String title, Date editionDate, String editorial, String author) {
        this.title = title;
        this.editionDate = editionDate;
        this.editorial = editorial;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthors(String author) {
        this.author = author;
    }
}
