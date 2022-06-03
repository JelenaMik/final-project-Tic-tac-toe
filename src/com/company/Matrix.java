package com.company;

import java.sql.Array;
import java.util.Random;
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
            }}
    }

    // print 1-9 matrix
    public void matrixNineOutput(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(numberMovesArray[i][j] + " ");
            }
            System.out.println();}
    }

    //generates matrix to work with
    public void matrixZeroGeneration(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                numberArray[i][j]=0;
            }}
    }

    //method for Zero matrix output
    public void matrixZeroOutput(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(numberArray[i][j] + "  ");
            }
            System.out.println();}
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
                }}
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
                sum=sumTemporary;
             }}
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
                sum=sumTemporary;
            }}
        return sum;
    }

    //method for Main Diagonal sum counting
    public int countSumMainDiagonal(){
        int sum=0;
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i==j){
                    sum = sum + numberArray[j][i];
                }}}
        return sum;
    }

    //method for Adj diagonal sum counting
    public int countSumAdjDiagonal(){
        int sum=0;
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i+j==2){
                    sum = sum + numberArray[j][i];
                }}}
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

        int value = playerField();
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

    public void setComputerValue(int n){
        int value = computerField();
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

    public void setHardComputerValue(int n){
        int value = calculateField();
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

    public int playerField(){
        int value = 0;
        do{
            int field = enterField();
            value=field;
        }while(fieldChecker(value)!=true) ;
        return value;
    }

    public int computerField(){
        int value = 0;
        do{
            int field = computerMove();
            value=field;
        }while(fieldChecker(value)!=true) ;
        return value;
    }

    //method to check if entered field is empty
    public boolean fieldChecker(int field){

            if(field>0 && field<4 && numberArray[0][field-1]==0){
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

   //method to check if there are any empty field in the matrix
    public boolean emptyFieldChecker(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (numberArray[i][j]==0){
                    return true;
                }}}
        return false;
    }

    public int computerMove(){
        Random random  = new Random();
        int number = 9;
        int field = random.nextInt(9)+1;
        return field;

    }

    public int sumRows(){

        //int sum=0;
        int row = 10;
        for(int i = 0; i<3; i++){
            int sumTemporary=0;
            for (int j=0; j<3; j++){
                sumTemporary = sumTemporary + numberArray[i][j];
            }
            if (Math.abs(sumTemporary)==2){
                row=i;
            }}
        return row;
    }

    public int sumColumns(){
        int column = 10;
        for(int i = 0; i<3; i++){
            int sumTemporary=0;
            for (int j=0; j<3; j++){
                sumTemporary = sumTemporary + numberArray[j][i];
            }
            if (Math.abs(sumTemporary)==2){
                column=i;
            }}
        return column;
    }

    public int sumMainDiagonal(){
        int sum=10;
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i==j){
                    sum = sum + numberArray[j][i];
                }}}
        return sum;
    }

    public int sumAdjDiagonal(){
        int sum=10;
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i+j==2){
                    sum = sum + numberArray[j][i];
                }}}
        return sum;
    }

    public int calculateField(){
        int field = 0;
        int row =sumRows();
        int column = sumColumns();
        int mainDiagonal = sumMainDiagonal();
        int adjDiagonal = sumAdjDiagonal();
        if (row<5){
            for(int i=0; i<3; i++){
                if (numberArray[row][i]==0){
                    field = i+3*row+1;
                }}
            return field;
        }
        else if (column<5){
            for(int i=0; i<3; i++){
                if (numberArray[i][column]==0){
                    field = column+3*i+1;
                }}
            return field;
        }
        else if (mainDiagonal==2 || mainDiagonal==-2){
            for(int i=0; i<3; i++){
                if (numberArray[i][i]==0){
                    field = i+3*i+1;
                }}
            return field;
        }
        else if (adjDiagonal==2 || adjDiagonal==-2){
            for(int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if (i+j==2 && numberArray[i][j]==0){
                        field = j+3*i+1;
                    }}}return field;
        }

        else if (numberArray[1][1]==0){return 5;}
        else if (numberArray[0][0]==0){return 1;}
        else if (numberArray[0][2]==0){return 3;}
        else if (numberArray[2][0]==0){return 7;}
        else if (numberArray[2][2]==0){return 9;}
        else if(numberArray[0][1]==0){return 2;}
        else if(numberArray[1][0]==0){return 4;}
        else if(numberArray[1][2]==0){return 6;}
        else if(numberArray[2][1]==0){return 8;}
        else{return 0;}

    }



}
