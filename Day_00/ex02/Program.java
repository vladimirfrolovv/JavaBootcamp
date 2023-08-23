package ex02;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int number = 0;
        int res = 0;
        boolean flag = true;
        while (true) {
            number = scan.nextInt();
            if (number == 42) break;
            res = 0;
            while (number > 0) {
                res += number % 10;
                number /= 10;
            }
            flag = true;
            for (int i = 2; i * i < res; ++i) {
                if(res % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                counter++;
            }
        }
        System.out.println("Count of coffee-request - " + counter);
    }
}