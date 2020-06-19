package com.practicecode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
    private int id;

    public Magazine(String title, Date editionDate, String editorial, String author) {
        super(title, editionDate, editorial, author);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n\n :: MAGAZINE ::" +
                "\nTitle: " + getTitle() +
                "\nEdition Date: " + getEditionDate() +
                "\nEditorial: " + getEditorial() +
                "\nAuthors: " + getAuthor();
    }

    public static ArrayList<Magazine> makeMagazinesList(){
        ArrayList<Magazine> magazines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Date dateLoop = new Date();
            magazines.add(new Magazine( "Title "+i, dateLoop, "Editorial "+i, "Autor "+i));
        }
        return magazines;
    }
}
