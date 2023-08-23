package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner(System.in);
        Reader reader = new Reader();
        Analyzer analyzer = new Analyzer();
        Map<String,String> signatures = reader.getSignatureFile();
        int max_length = reader.getMaxSignatureLength(signatures);
        try(FileOutputStream result = new FileOutputStream("src/ex00/result.txt")) {
            while (true) {
                String filepath = scan.nextLine();
                if ("42".equals(filepath)) {
                    break;
                } else {
                    if (filepath != null) {
                        System.out.println(analyzer.checkSignatureInFile(signatures, filepath, max_length, result));
                    }

                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
