package ex03;

import java.io.*;
import java.util.*;

public class Program {
    private static final String urls = "src/ex03/files_urls.txt";
    public static void main ( String[] args ) {
        if (args.length != 1 || !args[0].startsWith("--threadsCount=")) {
            System.err.println("Input valid data --threadsCount=(your value)");
            System.exit(-1);
        }
        int threads_count = Integer.parseInt(args[0].substring("--threadsCount=".length()));
        if (threads_count < 0 ) {
            System.out.println("Invalid count of threads");
            System.exit(-1);
        }
       try {
           BufferedReader reader = new BufferedReader(new FileReader(urls));
           String line;
           List< String> list_urls = new ArrayList<>();
           while ((line=reader.readLine()) != null) {
               String[] file_with_number = line.split(" ");
               list_urls.add(file_with_number[1]);
           }
           List<Dowloader> list_downloaders = new ArrayList<>(threads_count);
           for( int i = 0; i < threads_count; ++i) {
               Dowloader dowloader = new Dowloader(list_urls, i, threads_count);
               dowloader.start();
               list_downloaders.add(dowloader);
           }
           try {
                for ( Dowloader elem : list_downloaders) {
                    elem.join();
                }
           } catch (InterruptedException e) {
               System.err.println("Interrupted Exception");
           }

       } catch (FileNotFoundException e) {
           System.out.println("File Not Found");
       } catch (IOException e) {
           System.out.println(" IO Exception");
       }
    }

}
