package com.company;

import java.io.*;
import java.util.Scanner;

class Movies {
    String[] name;
    int[] score;
}

class helpBotSix // change the name to something appropriate
{
    // Method 1 code
    // This method is the main method and this is where the method is called.

    public static void main(String[] a) throws IOException {
        int[] scores = new int[100];
        String[] name = new String[100];
        runProgram(scores, name);

        System.exit(0);
    }

    // Method 2 code
    // This method gets the value from the method 'numberOfGenres' inputted and stores it as a final variable

    public static int getValue() {
        final int numb = inputNumberOfGenres(0);
        System.out.println(numb);

        return numb;
    }


    // Method 3 code
    // This method creates a 'createQuestions'.

    public static Movies createQuestions(String[] nm, int[] scr) {
        Movies newQuestions = new Movies();

        //newQuestions.name = nm;
        //newQuestions.score = scr;

        setMovieGenreName(newQuestions, nm);
        setUserScore(newQuestions, scr);

        Movies newQuestions1 = newQuestions;
        return newQuestions1;
    }

    // Method 4 code
    // This method asks the user to input the number of genres they would like to ask about

    public static int inputNumberOfGenres(int numberOfGenres) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many many movie genres would you like to know about?");
        numberOfGenres = scanner.nextInt();

        return numberOfGenres;
    }

    // Method 5 code
    // This method asks the user to input a question about the genre they would like to ask and the response is stored

    public static String inputString(String genreInputted) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(genreInputted);

        return scanner.nextLine();
    }

    // Method 6 code
    // This method asks the user to input a question about the genre they would like to ask and the response is stored
    public static String inputStringFile(String genreInputted) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(genreInputted);

        return scanner.nextLine();
    }

    // Method 7 code
    // This method asks the user to input a the score for the genre they aksed aboutand the response is stored

    public static int inputInt(int scoreInputted) {
        int answer;
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextInt();
        scoreInputted = answer;

        return scoreInputted;
    }

    // Method 8 code
    // This method gets the movie genre.

    public static String[] getMovieGenreName(Movies movieGenre) {
        return movieGenre.name;
    }


    // Method 9 code
    // This method sets the movie genre.

    public static Movies setMovieGenreName(Movies movieGenre, String[] genreName) {
        movieGenre.name = genreName;

        return movieGenre;
    }


    // Method 10 code
    // This method gets the users scores.

    public static int[] getUserScore(Movies scr) {
        return scr.score;
    }


    // Method 11 code
    // This method sets the users scores.

    public static Movies setUserScore(Movies scr, int[] a) {
        scr.score = a;

        return scr;
    }


    // Method 12 code
    // This method compares the user input to see if it is valid or not. If it is valid it prints a relevant message.
    public static String[] answerChoice(String[] returnedMovieValue, int i, int numberOfGenres) {
        int[] returnedScoreValue = new int[100];
        Movies nameValidation = createQuestions(returnedMovieValue, returnedScoreValue);

        System.out.println("You have 5 options to choose from: Action, Comedy, Science Fiction, Thriller and Horror.");

        for (i = 0; i < numberOfGenres; i++) {
            String movieGenreInput = inputString("Please ask me a question about a film genre.");

            if (movieGenreInput.contains("Action") & movieGenreInput.contains("?") | movieGenreInput.contains("action") & movieGenreInput.contains("?")) {
                returnedMovieValue[i] = "Action";
                System.out.println(getMovieGenreName(nameValidation)[i] + " movies are very tense. I particularly enjoy the explosions.");
            } else if (movieGenreInput.contains("Comedy") & movieGenreInput.contains("?") | movieGenreInput.contains("comedy") & movieGenreInput.contains("?")) {
                returnedMovieValue[i] = "Comedy";
                System.out.println(getMovieGenreName(nameValidation)[i] + " movies are very funny. I can't stop laughing sometimes.");
            } else if (movieGenreInput.contains("Science Fiction") & movieGenreInput.contains("?") | movieGenreInput.contains("Sci-Fi") & movieGenreInput.contains("?") | movieGenreInput.contains("science fiction") & movieGenreInput.contains("?") | movieGenreInput.contains("sci-fi") & movieGenreInput.contains("?")) {
                returnedMovieValue[i] = "Science Fiction";
                System.out.println(getMovieGenreName(nameValidation)[i] + " movies are very interesting. I really like watching about futuristic technology.");
            } else if (movieGenreInput.contains("Thriller") & movieGenreInput.contains("?") | movieGenreInput.contains("thriller") & movieGenreInput.contains("?")) {
                returnedMovieValue[i] = "Thriller";
                System.out.println(getMovieGenreName(nameValidation)[i] + " are very gripping. The suspense is too much for me too handle sometimes.");
            } else if (movieGenreInput.contains("Horror") & movieGenreInput.contains("?") | movieGenreInput.contains("horror") & movieGenreInput.contains("?")) {
                returnedMovieValue[i] = "Horror";
                System.out.println(getMovieGenreName(nameValidation)[i] + " movies are very scary. The jump scares always catch me out.");
            } else if (movieGenreInput.contains("Goodbye") | movieGenreInput.contains("goodbye")) {
                System.exit(0);
            } else {
                System.out.println("Please use a question mark or say a valid movie genre.");
            }

        }
        return returnedMovieValue;
    }


    // Method 13 code
    // This method checks the score the user inputted and checks if it is valid. It then stores it in an array.

    public static int[] numbers(int[] returnedScoreValue, String[] returnedMovieValue, int i, int numberOfGenres) {

        answerChoice(returnedMovieValue, 1, numberOfGenres);

        for (i = 0; i < numberOfGenres; i++) {
            Movies scoreValidation = createQuestions(returnedMovieValue, returnedScoreValue);
            System.out.println();
            System.out.println("What score would you give " + returnedMovieValue[i] + " out of 10.");
            returnedScoreValue[i] = inputInt(0);

            if (returnedScoreValue[i] >= 1 & returnedScoreValue[i] <= 10) {
                System.out.println("That is what I would have said too!");
            } else {
                while (!(returnedScoreValue[i] >= 1 & returnedScoreValue[i] <= 10)) {
                    System.out.println("That is an invalid option. Please enter a valid one.");
                    returnedScoreValue[i] = inputInt(0);
                }
            }

            System.out.println(getUserScore(scoreValidation)[i] + " is the score you have given.");
        }

        return returnedScoreValue;
    }


    // Method 14 code
    // This method method uses a bubble sort algorithm to reorder the scores.

    public static void bubbleSort(int[] returnedScoreValue, int numberOfGenres, String[] returnedMovieValue) {
        numbers(returnedScoreValue, returnedMovieValue, 3, numberOfGenres);

        for (int i = 0; i < returnedScoreValue.length - 1; i++) {
            for (int j = 0; j < returnedScoreValue.length - i - 1; j++) {
                if (returnedScoreValue[j] < returnedScoreValue[j + 1]) {
                    int temporary = returnedScoreValue[j];
                    String temporary2 = returnedMovieValue[j];
                    returnedScoreValue[j] = returnedScoreValue[j + 1];
                    returnedMovieValue[j] = returnedMovieValue[j + 1];
                    returnedScoreValue[j + 1] = temporary;
                    returnedMovieValue[j + 1] = temporary2;
                }
            }
        }

        System.out.println();
        System.out.println("These are the scores you have given sorted from high to low.");

        for (int i = 0; i < numberOfGenres; i++) {
            System.out.println(returnedMovieValue[i] + " is rated " + returnedScoreValue[i]);
        }
    }

    // Method 15 code
    // This method creates a file and stores the inputs within them.

    public static void fileInput(String[] answer) throws IOException {

        try {
            System.out.println();
            String ans = "";
            int count = 0;
            while (!ans.equals("x")) {
                ans = inputStringFile("Please enter a genre name to store that type of movie in a file. Please press x to exit.");
                if (!ans.equals("x")) {

                    if (ans.contains("Action")) {
                        FileWriter myWriter = new FileWriter("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Action.txt", true);
                        answer[count] = inputStringFile("Please enter a movie name to store");
                        BufferedWriter bw = new BufferedWriter(myWriter);
                        PrintWriter out = new PrintWriter(bw);
                        out.println(answer[count]);
                        out.close();
                        out.flush();
                        bw.close();
                        myWriter.close();
                        count = count + 1;

                    } else if (ans.contains("Comedy")) {
                        FileWriter myWriter = new FileWriter("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Comedy.txt", true);
                        answer[count] = inputStringFile("Please enter a movie name to store");
                        BufferedWriter bw = new BufferedWriter(myWriter);
                        PrintWriter out = new PrintWriter(bw);
                        out.println(answer[count]);
                        out.close();
                        out.flush();
                        bw.close();
                        myWriter.close();
                        count = count + 1;

                    } else if (ans.contains("Thriller")) {
                        FileWriter myWriter = new FileWriter("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Thriller.txt", true);
                        answer[count] = inputStringFile("Please enter a movie name to store");
                        BufferedWriter bw = new BufferedWriter(myWriter);
                        PrintWriter out = new PrintWriter(bw);
                        out.println(answer[count]);
                        out.close();
                        out.flush();
                        bw.close();
                        myWriter.close();
                        count = count + 1;
                    } else if (ans.contains("Horror")) {
                        FileWriter myWriter = new FileWriter("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Horror.txt", true);
                        answer[count] = inputStringFile("Please enter a movie name to store");
                        BufferedWriter bw = new BufferedWriter(myWriter);
                        PrintWriter out = new PrintWriter(bw);
                        out.println(answer[count]);
                        out.close();
                        out.flush();
                        bw.close();
                        myWriter.close();
                        count = count + 1;
                    } else if (ans.contains("Science Fiction")) {
                        FileWriter myWriter = new FileWriter("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Science Fiction.txt", true);
                        answer[count] = inputStringFile("Please enter a movie name to store.");
                        BufferedWriter bw = new BufferedWriter(myWriter);

                        PrintWriter out = new PrintWriter(bw);
                        out.println(answer[count]);
                        out.close();
                        out.flush();
                        bw.close();
                        myWriter.close();
                        count = count + 1;
                    } else {
                        System.out.println("I don't know that genre.");
                    }

                }

            }
        } catch (IOException e) {
        }
    }

    // Method 16 code
    // This method read the file and prints the inputs within them.
    public static void fileOutput() throws IOException {
        try {
            File myFile1 = new File("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Action.txt");
            File myFile2 = new File("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Comedy.txt");
            File myFile3 = new File("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Thriller.txt");
            File myFile4 = new File("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Horror.txt");
            File myFile5 = new File("C:\\Users\\shyam\\OneDrive\\Documents\\qmul\\Science Fiction.txt");

            String ans = "";
            int count = 0;
            while (!ans.equals("x")) {
                ans = inputStringFile("Which file would you like to view the contents of? Please press x to exit.");
                if (!ans.equals("x")) {

                    if (ans.contains("Action")) {
                        BufferedReader br = new BufferedReader(new FileReader(myFile1));
                        String st;
                        while ((st = br.readLine()) != null)
                            System.out.println(st);
                    } else if (ans.contains("Comedy")) {
                        BufferedReader br = new BufferedReader(new FileReader(myFile2));
                        String st;
                        while ((st = br.readLine()) != null)
                            System.out.println(st);
                    } else if (ans.contains("Thriller")) {
                        BufferedReader br = new BufferedReader(new FileReader(myFile3));
                        String st;
                        while ((st = br.readLine()) != null)
                            System.out.println(st);
                    } else if (ans.contains("Horror")) {
                        BufferedReader br = new BufferedReader(new FileReader(myFile4));
                        String st;
                        while ((st = br.readLine()) != null)
                            System.out.println(st);
                    } else if (ans.contains("Science Fiction")) {
                        BufferedReader br = new BufferedReader(new FileReader(myFile5));
                        String st;
                        while ((st = br.readLine()) != null)
                            System.out.println(st);
                    } else {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
        }
    }
    // Method 17 code
    // This method calls the method bubbleSort.

    public static void runProgram(int[] scoreValue, String[] genreValue) throws IOException {
//        System.out.println("Hello I am a help-bot.");
//        int numberOfGenres = getValue();
//        bubbleSort(scoreValue, numberOfGenres, genreValue);
        String[] ans = new String[100];
        fileInput(ans);
        fileOutput();
        return;
    }
}
