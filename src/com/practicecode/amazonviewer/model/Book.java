package com.practicecode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;

    public Book(String title, Date editionDate, String editorial, String author, String isbn) {
        super(title, editionDate, editorial, author);
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String isReaded() {
        String read = "";
        if(readed == true){
            read = "Si";
        } else {
            read = "No";
        }
        return read;
    }

    public boolean getIsReaded(){
        return readed;
    }


    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public String toString() {
        return "\n\n :: BOOK ::" +
                "\nTitle: " + getTitle() +
                "\nEdition Date: " + getEditionDate() +
                "\nEditorial: " + getEditorial() +
                "\nAuthors: " + getAuthor() +
                "\nISBN: " + getIsbn();
    }

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if(dateF.getSeconds() > dateI.getSeconds() ){
            setTimeReaded(dateF.getSeconds() - dateI.getSeconds());
        } else {
            setTimeReaded(0);
        }
    }

    public static ArrayList<Book> makeBookList(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {
            Date dateLoop = new Date();
            books.add(new Book("Book " + i, dateLoop, "Editorial " + i, "Autor " + i, "#3457" + i + "A"));
        }
        return books;
    }
}
