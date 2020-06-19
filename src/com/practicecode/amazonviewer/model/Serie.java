package com.practicecode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Serie extends Film{
    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String genre, String creator, int duration, short year, int sessionQuantity, ArrayList<Chapter> chapters) {
        super(title, genre, creator, duration);
        setYear(year);
        this.sessionQuantity = sessionQuantity;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter>  getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter>  chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "\n\n :: SERIE ::" +
                "\nTitle: " + getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration() +
                "\nSessión Quantity: " + getSessionQuantity();
    }

    public static ArrayList<Serie> makeSerieList(){
        ArrayList<Serie> series = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {
            series.add(new Serie("Serie "+i, "Genero "+i, "Creador "+i, 1200, (short)(2010 + i), 5, Chapter.makeChaptersList()));
        }
        return series;
    }
}
