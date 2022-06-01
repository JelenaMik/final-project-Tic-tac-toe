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
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(numberMovesArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //generates matrix to work with
    public void matrixZeroGeneration(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                numberArray[i][j]=0;
            }
        }
    }

    //method for Zero matrix output
    public void matrixZeroOutput(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(numberArray[i][j] + "  ");
            }
            System.out.println();
        }
    }


    //method for x and o matrix output
    public void matrixMovesOutput(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (numberArray[i][j]==0){
                    System.out.print("_ ");
                }if(numberArray[i][j]==1){
                    System.out.print("x ");
                }if (numberArray[i][j]==(-1)){
                    System.out.print("o ");
                }
            }
            System.out.println();
        }
    }

    //method for row sum counting
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

    //method for column sum counting
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

    //method for Main Diagonal sum counting
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

    //method for Adj diagonal sum counting
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

    //method to get a field number from the user
    public int enterField(){
        System.out.println("Enter the number of field!");
        Scanner scanner = new Scanner(System.in);
        int field = scanner.nextInt();
        return field;
    }


    //method to set correct value in Zero matrix
    public void setValue(int n){
        int value= 0;
        do{
            int field = enterField();
            value=field;
        }while(fieldChecker(value)!=true) ;


        if (value<4){
             numberArray[0][value-1]=n;
        }
        else if (value <7){
            numberArray[1][value-4]=n;
        }
        else{
            numberArray[2][value-7]=n;
        }
    }

    //method to check if entered field is empty
    public boolean fieldChecker(int field){

            if(field<4 && numberArray[0][field-1]==0){
                return true;
            }
            else if (4<=field && field<7 && numberArray[1][field-4]==0){
                return true;
            }
            else if(field<10 && field>=7 && numberArray[2][field-7]==0){
                return true;
            }
         return false;
    }

    public boolean emptyFieldChecker(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (numberArray[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }



}
