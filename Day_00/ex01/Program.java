package ex01;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        boolean flag = true;
        int counter = 1;
        for (int i = 2; i*i <= number && flag; ++i) {
            if (number % i == 0) {
                flag = false;
                break;
            }
            counter++;
        }

        System.out.printf("%b %d", flag, counter);
    }
}