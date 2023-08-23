package ex00;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {
private final String filename = "src/ex00/signatures.txt";
    public Map<String, String> getSignatureFile() {
        Map<String,String> signatures = new HashMap<String, String>();
            try(FileInputStream file = new FileInputStream(filename)) {
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    String one_signature = scan.nextLine();
                    String[] array_signatures = one_signature.split(", ");
                    if (array_signatures.length == 2) {
                        signatures.put(array_signatures[0], array_signatures[1]);
                    }
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return signatures;
    }
    public int getMaxSignatureLength(Map<String,String> signatures) {
        int max = 0;
        for (Map.Entry<String,String> elem : signatures.entrySet()) {
            if (elem.getValue().length() > max) {
                max = elem.getValue().length();
            }
        }
        return max;
    }
}
