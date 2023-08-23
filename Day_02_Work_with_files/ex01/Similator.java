package ex01;


import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.*;

public class Similator {
    private final String file_dict = "src/ex01/dictionary.txt";

    public double getSimilarity ( String file1, String file2 ) throws IOException {
        double sim = 0.0;
        try (BufferedReader rfile1 = new BufferedReader(new FileReader(file1)); BufferedReader rfile2 = new BufferedReader(new FileReader(file2));) {
            Set<String> dictionaty = new TreeSet<String>();
            try {
                Scanner scan1 = new Scanner(rfile1);
                Scanner scan2 = new Scanner(rfile2);
                if (!scan1.hasNext() || !scan2.hasNext()) {
                    return sim;
                }
                String line_1 = scan1.useDelimiter("\\Z").next();
                String line_2 = scan2.useDelimiter("\\Z").next();
                String[] parts_1 = line_1.split("\\s+");
                String[] parts_2 = line_2.split("\\s+");
                Map<String, Integer> map_1 = new HashMap<String, Integer>();
                Map<String, Integer> map_2 = new HashMap<String, Integer>();
                ;
                for (String elem : parts_1) {
                    if (map_1.containsKey(elem)) {
                        map_1.put(elem, map_1.get(elem) + 1);
                    } else {
                        map_1.put(elem, 1);
                    }

                    dictionaty.add(elem);
                }
                for (String elem : parts_2) {
                    if (map_2.containsKey(elem)) {
                        map_2.put(elem, map_2.get(elem) + 1);
                    } else {
                        map_2.put(elem, 1);
                    }
                    dictionaty.add(elem);
                }


                Vector<Integer> result_1_file = new Vector<Integer>(dictionaty.size());
                Vector<Integer> result_2_file = new Vector<Integer>(dictionaty.size());
                for (String elem : dictionaty) {
                    result_1_file.add(map_1.getOrDefault(elem, 0));
                    result_2_file.add(map_2.getOrDefault(elem, 0));
                }
                double numerator = 0;
                double denumirator_p1 = 0;
                double denumirator_p2 = 0;
                for (int i = 0; i < result_1_file.size(); ++ i) {
                    numerator += (result_1_file.get(i) * result_2_file.get(i));
                    denumirator_p1 += result_1_file.get(i) * result_1_file.get(i);
                    denumirator_p2 += result_2_file.get(i) * result_2_file.get(i);
                }

                sim = numerator / (Math.sqrt(denumirator_p1) * Math.sqrt(denumirator_p2));
                rfile1.close();
                rfile2.close();
                return sim;
            } catch (NoSuchFileException e) {
                return 0.0;
            }
        } catch (IOException e) {

        }
        return sim;
    }

    public void writeToDictionary ( Set<String> dictionary )throws IOException {
        try (BufferedWriter dictionary_file = new BufferedWriter(new FileWriter(file_dict));) {
            for (String elem : dictionary) {
                dictionary_file.write(elem + '\n');
            }
            dictionary_file.close();
        } catch (IOException e) {
            String r = e.getMessage();
            System.out.println(r);
        }
    }
}
