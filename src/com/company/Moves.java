package com.company;

import java.sql.Array;
import java.util.Random;
import java.util.Scanner;

public class Moves  extends Matrix{

    int player =0;

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
            //matrixMovesOutput();
            matrixZeroOutput();

            temporary = countSumMainDiagonal();
            //System.out.println("GD " + temporary);
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary=countSumAdjDiagonal();
            //System.out.println("AD " + temporary);
            if (temporary==3 || temporary==-3){sum=temporary;}
            temporary = countSumColumns();
            //System.out.println("Columns " + temporary);
            if (temporary==3 || temporary==-3){sum=temporary;}
            //System.out.println("Summa " + sum);
            temporary = countSumRows();
            //System.out.println("Rows " + temporary);
            if (temporary==3 || temporary==-3){sum=temporary;}
            //System.out.println("Summa " + sum);

        }while(sum==0);

        System.out.println("Kāds uzvarēja");

    }






}


