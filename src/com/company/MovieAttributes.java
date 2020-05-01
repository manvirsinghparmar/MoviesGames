package com.company;


import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieAttributes  {

    private String hiddenMovie;

    private  String movieName;

    private  static ArrayList<String> movieList = new ArrayList<>();

     void readMovieFromDataFile() {

        File file = new File("movies.txt");

        try {
             Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                movieName = scanner.nextLine();
                movieList.add(movieName);
            }
            scanner.close();


        }catch (Exception e){}

    }

    public String randomMovie(){

        String randomMovie;

        randomMovie= movieList.get(new Random().nextInt(movieList.size()));

        //System.out.println("The random movie in RANDOM METHOD :" + randomMovie+ "\n");

        hiddenMovie=randomMovie.replaceAll("(?s).", "*");

        System.out.println("The movie to guess has: "+ hiddenMovie +" "+"characters" + "\n");

        return randomMovie;

    }

    public  String getHiddenMovie() {
        return hiddenMovie;

    }
}
