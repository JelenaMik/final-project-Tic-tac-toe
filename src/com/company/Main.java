package com.company;

public class Main {

    public static void main(String[] args) {

        Matrix matrix9 = new Matrix();
        matrix9.matrixNineGeneration();
        matrix9.matrixNineOutput();

        System.out.println();

        Matrix matrix = new Matrix();
        matrix.matrixMovesOutput();
        matrix.matrixZeroGeneration();

        System.out.println();

        Moves move = new Moves();

        move.game();


    }
}
