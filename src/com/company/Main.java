package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Matrix matrix9 = new Matrix();
        matrix9.matrixNineGeneration();
        System.out.println("Choose number where you want to go!");
        matrix9.matrixNineOutput();

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String input = "";
        int i = 0;

        do {
            Matrix matrix = new Matrix();
            Moves move = new Moves();
            i++;
            if (i>1){
                System.out.println();
                System.out.println("""
            Do you want to play another game?
            1. Yes
            2. No
            """);
            } else{
                System.out.println("Press 1 to start!");
            }


            input = scanner.nextLine();
            switch (input){
                case "1":
                    matrix.matrixZeroGeneration();
                    matrix.matrixZeroOutput();
                    move.game();
                    break;
                default:
                    System.out.println("Please enter a valid input!");
                    break;
            }

        }while(!input.equalsIgnoreCase("2"));
    }
}


