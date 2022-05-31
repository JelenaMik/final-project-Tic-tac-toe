package com.company;

import java.sql.Array;
import java.util.Scanner;

public class Matrix{

    //Matrix to work with
    int [][] numberArray = new int[3][3];

    //Matrix to show to
    int [][] numberMovesArray = new int[3][3];

    //generates the 1-9 matrix
    public void matrixNineGeneration(){
        int count=0;
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                ++count;
                numberMovesArray[i][j]=count;
            }
        }
    }

    // print 1-9 matrix
    public void matrixNineOutput(){
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                System.out.print(numberMovesArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //generates matrix to work with
    public void matrixZeroGeneration(){
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                numberArray[i][j]=0;
            }
        }
    }

    public void matrixZeroOutput(){
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                System.out.print(numberArray[i][j]);
            }
            System.out.println();
        }
    }



    public void matrixMovesOutput(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (numberArray[i][j]==0){
                    System.out.print("_ ");
                }if(numberArray[i][j]==1){
                    System.out.print("x ");
                }if (numberArray[i][j]==(-1)){
                    System.out.println("o ");
                }
            }
            System.out.println();
        }
    }

    public int countSumRows(){
        int sum=0;
        for(int i = 0; i<3; i++){

            int sumTemporary=0;
            for (int j=0; j<3; j++){
                sumTemporary = sumTemporary + numberArray[i][j];
            }

            if (Math.abs(sum)<Math.abs(sumTemporary)){
                //sum=Math.abs(sumTemporary);
                sum=sumTemporary;
             }
        }
        return sum;
    }

    public int countSumColumns(){
        int sum=0;
        for(int i = 0; i<3; i++){

            int sumTemporary=0;
            for (int j=0; j<3; j++){

                sumTemporary = sumTemporary + numberArray[j][i];
            }
            if (Math.abs(sum)<Math.abs(sumTemporary)){
//                sum=Math.abs(sumTemporary);
                sum=sumTemporary;
            }
        }
        return sum;
    }

    public int countSumMainDiagonal(){
        int sum=0;
        for(int i = 0; i<3; i++){

            for (int j=0; j<3; j++){
                if (i==j){
                    sum = sum + numberArray[j][i];
                }
            }

        }
        return sum;
    }

    public int countSumAdjDiagonal(){
        int sum=0;
        for(int i = 0; i<3; i++){


            for (int j=0; j<3; j++){
                if (i+j==2){
                    sum = sum + numberArray[j][i];
                }
            }

        }
        return sum;
    }

    public int enterField(){
        System.out.println("Enter the number of field!");
        Scanner scanner = new Scanner(System.in);
        int field = scanner.nextInt();
        return field;
    }



    public void setValue(int n){
        int field = enterField();
        if (field<4){
            numberArray[0][field-1]=n;
        }
        else if (field<7){
            numberArray[1][field-4]=n;
        }
        else {
            numberArray[2][field-7]=n;
        }
    }

}
