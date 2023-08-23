package ex01;

import java.io.IOException;

public class Program {
    public static void main ( String[] args ) throws IOException {
      Similator similator = new Similator();
      System.out.println("Similarity = " + Math.floor(similator.getSimilarity("src/ex01/"+ args[0], "src/ex01/"+ args[1]) * 100) / 100.0);
    }
}
