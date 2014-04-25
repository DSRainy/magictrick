/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymagictrick;

import java.util.Scanner;

/**
 *
 * @author Rain
 */
public class MagicCard {

    Integer[][] numberOfCard = new Integer[4][4];
    Integer[] firstCardTemp = {0, 0, 0, 0};
    Integer[] secondCardTemp = {0, 0, 0, 0};
    int firstRowSelected = 0;
    int secondRowSelected = 0;
    int roundSelected = 1;

    public void setCard(Integer c[][][], int numberOfDeck) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numberOfCard[i][j] = c[numberOfDeck][i][j];
            }
        }

    }

//    public void shuffleCard() {
//        int random;
//        Integer temp[] = new Integer[16];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                do {
//                    random = (int) (Math.random() * 16 + 1);
//                } while (temp[random - 1] != null);
//                temp[random - 1] = random;
//                numberOfCard[i][j] = random;
//            }
//        }
//    }
//    public void printNumberOfCard() {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(this.numberOfCard[i][j] + "  ");
//            }
//            System.out.println("\n");
//        }
//    }
    public void selectedRowCard(int row) {

        if (this.roundSelected == 1) {

            this.firstRowSelected = row - 1;

            for (int i = 0; i < 4; i++) {
                firstCardTemp[i] = this.numberOfCard[this.firstRowSelected][i];
                System.out.print(firstCardTemp[i] + " ");
            }
            System.out.println("");
            this.roundSelected++;

        } else if (this.roundSelected == 2) {

            this.secondRowSelected = row - 1;
            for (int i = 0; i < 4; i++) {
                secondCardTemp[i] = this.numberOfCard[this.firstRowSelected][i];
                System.out.print(secondCardTemp[i] + " ");
            }
            System.out.println("");
            this.roundSelected = 1;
        }

    }

    public String checkRowCardSelect() {
        int numberSameCard = 0;
        int sameCardTemp = 0;
        String output = " ";

        for (int i = 0; i < 4; i++) {

            if (firstCardTemp[i].equals(secondCardTemp[i])) {
                sameCardTemp = this.firstCardTemp[i];
                numberSameCard++;
                //System.out.println("numberSameCard = " + numberSameCard);
            }
        }
        //System.out.println("Real numberSameCard = " + numberSameCard);
        if (numberSameCard == 1) {
            numberSameCard = 0;
            output = "Case #1: " + sameCardTemp;
//            System.out.println("Case #1: " + sameCardTemp);
        } else if (numberSameCard > 1) {
            numberSameCard = 0;
            output = "Case #2: Bad magician!";
//            System.out.println("Case #2: Bad magician!");
        } else if (numberSameCard < 1) {
            numberSameCard = 0;
            output = "Case #3: Volunteer cheated!";
            
//            System.out.println("Case #3: Volunteer cheated!");
        }
        return output;
        

    }

}