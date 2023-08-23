package ex00;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Analyzer {

    public String checkSignatureInFile(Map<String, String>  signatures, String filename, int max_length, FileOutputStream res) {
        try (FileInputStream new_file = new FileInputStream(filename); ) {

            byte[] bytes = new byte[max_length];
            int buf = new_file.read(bytes);
            StringBuilder result = new StringBuilder();
            for (byte elem : bytes) {
                result.append(String.format("%02X ", elem));
            }
            boolean flag = true;
            char[] array_signature = result.toString().trim().toCharArray();
            for ( Map.Entry<String,String> elem : signatures.entrySet()) {
                flag = true;
                char[] array = elem.getValue().toCharArray();
                for (int i = 0, j = 0; i < elem.getValue().length(); ++i, ++j) {
                    if (array[i] != array_signature[i]) {
                        if ( array[i] != ' ') {
                            flag = false;
                            break;
                        }

                    }
                }
                if (flag) {
                    res.write(elem.getKey().getBytes(), 0 , elem.getKey().getBytes().length);
                    res.write("\n".getBytes(), 0 , "\n".getBytes().length);
                    return "PROCESSED";
                }


            }
            res.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return "UNDEFINED";
    }

}
