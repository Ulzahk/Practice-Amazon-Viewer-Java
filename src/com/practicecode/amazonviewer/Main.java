package com.practicecode.amazonviewer;

import com.practicecode.amazonviewer.model.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        int exit = 1;
        do{
            System.out.println("BIENVENIDOS AMAZON VIEWER\n");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");
            //Leer respuesta
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 0:
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    break;
                case 6:
                    makeReport(new Date());
                    break;
                default:
                    System.out.println("\n..... Selecciona una opción.....\n");
                    break;
            }
        } while ( exit != 0);
    }
    static ArrayList<Movie> movies = Movie.makeMoviesList();
    public static void showMovies(){
        int exit = 1;
        do {
            System.out.println("\n:: MOVIES ::\n");
            for (int i = 0; i < movies.size() ; i++) { // 1. Movie 1
                System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menú\n");

            //Leer respuesta del Usuario
            Scanner sc = new Scanner(System.in);
            int responseMovies = Integer.valueOf(sc.nextLine());

            if(responseMovies == 0){
                exit = 0;
                showMenu();
            } else if (responseMovies > 0){
                //Comenzo a verla
                Movie movieSelected = movies.get(responseMovies - 1);
                movieSelected.setViewed(true);
                Date dateI = movieSelected.startToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("........................");
                }

                //Termino de verla
                movieSelected.stopToSee(dateI, new Date());
                System.out.println("\nViste:\n " + movieSelected);
                System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
            }
        }while (exit !=0);
    }
    static ArrayList<Serie> series = Serie.makeSerieList();
    public static void showSeries(){
        int exit = 1;

        do {
            System.out.println("\n:: SERIES ::\n");
            for (int i = 0; i < series.size() ; i++) { // 1. Movie 1
                System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menú\n");
            //Leer respuesta del Usuario
            Scanner sc = new Scanner(System.in);
            int responseSeries = Integer.valueOf(sc.nextLine());

            if(responseSeries == 0){
                showMenu();
            } else if(responseSeries > 0){
                showChapters(series.get(responseSeries -1).getChapters());
            }
        }while (exit !=0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected){
        int exit = 0;
        do {
            System.out.println("\n:: CHAPTERS ::\n");
            for (int i = 0; i < chaptersOfSerieSelected.size() ; i++) { // 1. Movie 1
                System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() +
                        " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menú\n");
            //Leer respuesta del Usuario
            Scanner sc = new Scanner(System.in);
            int responseChapters = Integer.valueOf(sc.nextLine());

            if(responseChapters == 0){
                exit = 0;
                showMenu();
            } else if(responseChapters > 0){
                Chapter chapterSelected = chaptersOfSerieSelected.get(responseChapters -1);
                chapterSelected.setViewed(true);
                Date dateI = chapterSelected.startToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("........................");
                }
                //Termino de verla
                chapterSelected.stopToSee(dateI, new Date());
                System.out.println("\nViste:\n " + chapterSelected);
                System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
            }
        }while(exit != 0);
    }

    static ArrayList<Book> books = Book.makeBookList();
    public static void showBooks(){
        int exit = 1;
        do {
            System.out.println("\n:: BOOKS ::\n");
            for (int i = 0; i < books.size() ; i++) { // 1. Movie 1
                System.out.println(i+1 + ". " + books.get(i).getTitle() + " Visto: " + books.get(i).isReaded());
            }
            System.out.println("0. Regresar al Menú\n");

            //Leer respuesta del Usuario
            Scanner sc = new Scanner(System.in);
            int responseBooks = Integer.valueOf(sc.nextLine());

            if(responseBooks == 0){
                exit = 0;
                showMenu();
            } else if (responseBooks > 0){
                //Comenzo a verla
                Book bookSelected = books.get(responseBooks - 1);
                bookSelected.setReaded(true);
                Date dateI = bookSelected.startToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("........................");
                }

                //Termino de verla
                bookSelected.stopToSee(dateI, new Date());
                System.out.println("\nViste:\n " + bookSelected);
                System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
            }
        }while (exit !=0);
    }

    public static void showMagazines(){
        int exit = 0;
        ArrayList<Magazine> magazines = Magazine.makeMagazinesList();
        do {
            System.out.println("\n:: MAGAZINES ::\n");
            for (int i = 0; i < magazines.size() ; i++) {
                System.out.println(i+1+". "+magazines.get(i).getTitle()+ " Autor: "+
                        magazines.get(i).getAuthor());
            }

            System.out.println("0. Regresar al Menú\n");
            //Leer respuesta del Usuario
            Scanner sc = new Scanner(System.in);
            int responseMagazines = Integer.valueOf(sc.nextLine());

            if(responseMagazines == 0){
                exit = 0;
                showMenu();
            }
        }while (exit !=0);
    }

    public static void makeReport(){
        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(" :: VISTOS ::");
        String contentReport = "";
        for (Movie movie: movies) {
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        for (Serie serie: series) {
            if(serie.getIsViewed()){
                contentReport += serie.toString();
            }
        }
        for (Book book: books) {
            if(book.getIsReaded()){
                contentReport += book.toString();
            }
        }


        report.setContent(contentReport);
        report.makeReport();
    }

    public static void makeReport(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("reporte"+dateString);
        report.setExtension("txt");
        report.setTitle(" :: VISTOS ::");
        String contentReport = "";
        for (Movie movie: movies) {
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        for (Serie serie: series) {
            if(serie.getIsViewed()){
                contentReport += serie.toString();
            }
        }
        for (Book book: books) {
            if(book.getIsReaded()){
                contentReport += book.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }

}
