package com.company;

public class Main {

    public static void main(String[] args) {

        Matrix matrix9 = new Matrix();
        matrix9.matrixNineGeneration();
        matrix9.matrixNineOutput();

        System.out.println();

        Matrix matrix = new Matrix();
        matrix.matrixNineOutput();
        matrix.matrixZeroGeneration();

        Moves move = new Moves();

//        if (move.firstMove() == 1) {
//            System.out.println("The first move is your!");
//        } else {
//            System.out.println("Computer makes the first move!");
//        }


        move.game();


    }
}
