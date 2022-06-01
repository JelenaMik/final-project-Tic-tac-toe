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
            }else {
                System.out.println("2. Player's move");
            }

            setValue(n);
            matrixMovesOutput();
            matrixZeroOutput();

            temporary = countSumMainDiagonal();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary=countSumAdjDiagonal();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary = countSumColumns();
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary = countSumRows();
            if (temporary==3 || temporary==-3){sum=temporary;}

        }while(sum==0);
        if (sum==3){
            System.out.println("First player won!");
        }
        if (sum==-3){
            System.out.println("Second player won!");
        }


    }

}


