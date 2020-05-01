package com.company;

import java.util.Scanner;

public class Main  {

    private static int character_index;

    private static int noOfWrongAttempts=10;

    private static MovieAttributes movieAttributes= new MovieAttributes();

    public static void main(String[] args) {

        System.out.println("\n"+"Welcome to the movie name guessing game where you have 10 chances to guess all characters of a movie name!!!!  "+ "\n");

        movieAttributes.readMovieFromDataFile();

        userInputHandling();

    }

     static void userInputHandling() {

        char user_input_character;

        String nameOfRandomMovie = movieAttributes.randomMovie();

         String thehiddenmovie = movieAttributes.getHiddenMovie();

        for(int i=0;i<25 && noOfWrongAttempts!=0;i++){

        System.out.print("Enter a letter: ");

        Scanner scanner = new Scanner(System.in);

        user_input_character = scanner.nextLine().charAt(0);

        character_index = nameOfRandomMovie.indexOf(String.valueOf(user_input_character));

        if(nameOfRandomMovie.contains(String.valueOf(user_input_character))){

            StringBuilder stringBuilder=new StringBuilder(thehiddenmovie);


            for (int j = 0; j < nameOfRandomMovie.length(); j++) {

                if (nameOfRandomMovie.charAt(j) == user_input_character) {

                    stringBuilder.setCharAt(j, user_input_character);

                    thehiddenmovie = stringBuilder.toString();

                    System.out.println("Movie Guesses: " + "" + thehiddenmovie);
                }
            }
        }
        else
        {
            noOfWrongAttempts--;
        System.out.println("you have "+ " " + noOfWrongAttempts+ " "+ "chances left");

        }

            if(!thehiddenmovie.contains("*")){

                System.out.println("WOW!!!!!! You have guessed the movie name correctly "+ "\n");

                System.out.println("GAME WON !!!!!");
                break;
            }

        }

        if(noOfWrongAttempts==0){

            System.out.println("Games lost" +"\n");
            System.out.println("You don't have any more chances left to guess"+"\n");
            System.out.println("The name of the movie to be guessed was : " + nameOfRandomMovie + "\n");
        }



        }


}
