package ex02;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static int[] array;
    public static int[] sums;
    public static int sum;
    public static int current_thread = 1;
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Input valid data --arraySize=(your value) --threadsCount=(your value)");
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);
        int array_size = Integer.parseInt(args[0].substring("--arraySize=".length()));
        int threads_count = Integer.parseInt(args[1].substring("--threadsCount=".length()));
        if (array_size < 0 || array_size > 2000000) {
            System.err.println("Invalid array size");
            System.exit(-1);
        }
        if (threads_count <= 0 || threads_count > array_size) {
            System.err.println("Invalid thread count");
            System.exit(-1);
        }
        Random random = new Random();
        array = new int[array_size];
        sums = new int[threads_count];
        for (int i = 0; i < array_size; i++) {
            array[i] =  random.nextInt(1001 + 1000) - 1000;

        }
        int realSum = 0;
        for (int i = 0; i < array_size; i++) {
            realSum += array[i];
        }
        System.out.println("Sum: " + realSum);
        int byThreadSum = 0;
        int numberOfElementsInOneThread = (int)Math.ceil((double)(array_size) / (double)(threads_count));
        int[] sums = new int[threads_count];
        for (int i = 0; i < sums.length; i++) {
            int start = i * numberOfElementsInOneThread;
            int end = Math.min((i + 1) * numberOfElementsInOneThread - 1, array_size - 1);
            SumThread SumThread = new SumThread(start, end);
            SumThread.start();
            try {
                SumThread.join();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException();
            }
            sums[i] = sum;
            byThreadSum += sums[i];
        }
        System.out.println("Sum by threads: " + byThreadSum);

    }
}
