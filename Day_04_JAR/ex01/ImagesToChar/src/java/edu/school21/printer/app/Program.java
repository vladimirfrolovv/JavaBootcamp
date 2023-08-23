package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {
    public static void main ( String[] args ) {
        if (args.length != 2 || !args[0].startsWith("--white=") || !args[1].startsWith("--black=")){
            throw new IllegalArgumentException("Invalid Input");
        }
        char white_pix = args[0].charAt("--white=".length());
        char black_pix = args[1].charAt("--black=".length());
       try {
           int[][] array_pix = Logic.convertImage(white_pix, black_pix);
           for (int i = 0; i < array_pix.length; ++i) {
               for (int j = 0; j < array_pix[i].length; ++j) {
                   System.out.print((char)array_pix[j][i]);
               }
               System.out.println();
           }
       } catch (Exception e) {
           System.out.println("Invalid Image");
       }


    }
}
