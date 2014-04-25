/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymagictrick;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import mymagictrick.MagicCard;

/**
 *
 * @author Rain
 */
public class MyMagicTrick {

    /**
     * @param args the command line arguments
     */
    static BufferedReader in = null;
    static BufferedWriter out = null;

    public static void main(String[] args) {

        Integer[][][] numberOfCard = new Integer[200][4][4];
        Integer[] inputRow = new Integer[200];
        int round = 0;
        int count = 0;
        int countInputRow = 0;
        int countInputRowNumberOfCard = 0;
        int countInputColumnNumberOfCard = 0;
        int countDeck = 0;

        try {
            FileReader inputFile = new FileReader("C:\\Users\\Rain\\Desktop\\mymagictrick\\input.txt");
            Scanner inFile = new Scanner(inputFile);
//            in = new BufferedReader(inputFile);
//            String s = new String();
//            StringTokenizer strtk;
            int i;
            while (inFile.hasNextInt()) {
                i = inFile.nextInt();
                if (count == 0) {
                    round = i;
                    count++;
                }
                if (count == (count * 18 - 16)) {
                    inputRow[countInputRow] = i;
                    countInputRow++;
                } else {
                    if (countInputRowNumberOfCard < 4) {
                        if (countInputColumnNumberOfCard < 4) {
                            numberOfCard[countDeck][ countInputRowNumberOfCard][countInputColumnNumberOfCard] = i;
                            countInputColumnNumberOfCard++;
                        }
                        if (countInputColumnNumberOfCard == 4) {
                            countInputColumnNumberOfCard = 0;
                        }
                        countInputRowNumberOfCard++;
                    }
                    if (countInputRowNumberOfCard == 4) {
                        countInputRowNumberOfCard = 0;
                    }
                    countDeck++;
                }
//                strtk = new StringTokenizer(s);
//                while (strtk.hasMoreTokens()) {
//                    i = Integer.parseInt(strtk.nextToken());
//
//                }
            }
        } catch (FileNotFoundException e2) {
            System.out.println(e2.getMessage());
        } catch (ArrayIndexOutOfBoundsException e3) {
            System.out.println("Please input filename");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e4) {
                System.out.println("Cannot close BufferedReader");
            }
        }

        MagicCard card = new MagicCard();

        count = 0;
        while (count < round*2) {
            card.setCard(numberOfCard, count);
            card.selectedRowCard(inputRow[count]);
            card.setCard(numberOfCard, count + 1);
            card.selectedRowCard(inputRow[count + 1]);
            
            try {
                FileWriter outputFile = new FileWriter("C:\\Users\\Rain\\Desktop\\mymagictrick\\output.out");
                out = new BufferedWriter(outputFile);
                out.write(card.checkRowCardSelect());
            } catch (EOFException e1) {
                System.out.println("End of stream");
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            } catch (ArrayIndexOutOfBoundsException e3) {
                System.out.println("Please input filename");
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e4) {
                    System.out.println("Cannot close BufferedWriter");
                }
            }
            
            count += 2;
        }
//        card.setCard();
//        card.printNumberOfCard();

//        System.out.print("Select first row : ");
//        inputRow = scan.nextInt();
//        inputRow = checkInput(inputRow);
//        System.out.println("Choose : " + inputRow);
//
//        card.selectedRowCard(inputRow);
//
//        card.shuffleCard();
//
//        System.out.print("Select Second row : ");
//        inputRow = scan.nextInt();
//        inputRow = checkInput(inputRow);
//        System.out.println("Choose : " + inputRow);
//
//        card.selectedRowCard(inputRow);
//
//        card.printNumberOfCard();
//        card.checkRowCardSelect();
    }

//    public static void startProgram(MagicCard card) {
//
//    }
//
//    public static int checkInput(int inputRow) {
//        while (inputRow < 1 || inputRow > 4) {
//            System.out.println("error Select please try again.");
//            System.out.print("Select : ");
//            Scanner input = new Scanner(System.in);
//            inputRow = input.nextInt();
//
//        }
//        return inputRow;
//    }
}
