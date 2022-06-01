package com.company;

import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class Moves  extends Matrix{

    int player =0;

    //method to randomly choose a first player
    public int firstMove(){
        Random random  = new Random();
        int firstPlayer = random.nextInt()%2;
        if (firstPlayer==1){
            System.out.println("The first player uses x ");
        }else{
            firstPlayer=-1;
            System.out.println("The first player uses o ");
        }

        return firstPlayer;
    }

    //method for one single game
    public void game(){

        int value = firstMove();


        int sum = 0;
        int temporary = 0;
        int movesCount = 0;
        int n=0;
        do{
            movesCount++;
            n= (int) Math.pow(-1, movesCount)*value;
            if (n>0){
                System.out.println("1. Player's move");
                setValue(n);
            }else {
                System.out.println("Computer's move");
                setComputerValue(n);
            }

//            setValue(n);
            matrixMovesOutput();

            temporary = countSumMainDiagonal();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary=countSumAdjDiagonal();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary = countSumColumns();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary = countSumRows();
            if (temporary==3 || temporary==-3){sum=temporary;}

            if (sum==3){
                System.out.println("First player won!");
            }
            else if (sum==-3){
                System.out.println("Second player won!");
            }

            else if (emptyFieldChecker()==false){
                sum=5;
                System.out.println("Drawn!");
            }

        }while(sum==0);


    }

}


