package ex03;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Dowloader extends Thread {
    private List<String> list_urls;
    private final String outputDirectory = "src/ex03/downloads";
    private final int id_of_thread;
    private int id_of_file = 0;
    private final int threads_count;

    Dowloader (List<String> list_urls, int id_of_thread, int threads_count) {
        this.list_urls = list_urls;
        this.id_of_thread = id_of_thread;
        this.threads_count = threads_count;
    }
    @Override
    public void run () {
        try {
            for (int i = id_of_thread; i < list_urls.size(); i+=threads_count) {
                this.id_of_file = i;
                downloadFile(list_urls.get(i));

            }
        }catch (IOException e) {
            System.out.println("Error IO");
            }
        }

    public void downloadFile(String url1) throws IOException {
        System.out.printf("Thread-%d start download file number %d\n", id_of_thread +1,id_of_file + 1);
        try {
            URL url = new URL(url1);
            InputStream inputStream = url.openStream();
            Files.createDirectories(Paths.get(outputDirectory));
            String fileName = url1.substring(url1.lastIndexOf('/') + 1);
            String outputPath = outputDirectory + File.separator + fileName;
            Files.copy(inputStream, Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.getMessage();
        }

        System.out.printf("Thread-%d finish download file number %d\n", id_of_thread + 1,id_of_file +1);
    }
}
