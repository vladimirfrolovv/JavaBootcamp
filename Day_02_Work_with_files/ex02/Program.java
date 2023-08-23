package ex02;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Program {
    private static Path path;

    public static void main ( String[] args ) throws IOException {
        if (args.length != 1 || ! args[0].startsWith("--current-folder=")) {
            System.err.println("Input Filepath");
            System.exit(- 1);
        }
        path = Paths.get(args[0].substring(("--current-folder=").length()));
        if ( !Files.isDirectory(path)) {
            System.err.println("Invalid Data");
            System.exit(-1);
        }
        System.out.println(path);

        Scanner scan = new Scanner(System.in);
        worker(scan);

    }

    public static void worker ( Scanner scanner ) throws IOException {
        while ( true ) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");
            if (command.length == 1 && "ls".equals(command[0])) {
                lsCommand();
            } else if (command.length == 2 && "cd".equals(command[0])) {
                cdCommand(command[1]);
            } else if (command.length == 3 && "mv".equals(command[0])) {
                mvCommand(command[1], command[2]);
            } else if (command.length == 1 && "exit".equals(command[0]) ) {
                break;
            } else {
                System.out.println("Invalid options");
            }
        }
    }

    public static void lsCommand ( ) {
        try (DirectoryStream<Path> current_files = Files.newDirectoryStream(path)) {


            for (Path elem : current_files) {
                long size = 0;
                if (Files.isDirectory(elem)) {
                    size = Files.walk(elem)
                            .filter(p -> p.toFile().isFile())
                            .mapToLong(p -> p.toFile().length())
                            .sum();

                } else {
                   size = Files.size(elem);
                }
                System.out.println(elem.getFileName() + " " + (size / 1024) + " KB");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cdCommand ( String filepath ) {
        Path path_tmp = Paths.get(filepath);
        path_tmp = path.resolve(path_tmp).normalize();
        if (Files.isDirectory(path_tmp) && Files.exists(path_tmp)) {
            path = path_tmp;
            System.out.println(path);
        } else {
            System.out.println( filepath + "Is Not Directory");
        }
    }
public static void mvCommand (String file1 , String file2) throws IOException {
    Path path_tmp_1 = path.resolve(file1);
    Path path_tmp_2 = path.resolve(file2);
    if (Files.exists(path_tmp_1)) {
        if (Files.isDirectory(path_tmp_2)) {
            path_tmp_2 = path_tmp_2.resolve(path_tmp_1.getFileName());
        }
        Files.move(path_tmp_1, path_tmp_2, StandardCopyOption.REPLACE_EXISTING);
    } else {
        System.out.println("File NOT found");
    }
}
}
