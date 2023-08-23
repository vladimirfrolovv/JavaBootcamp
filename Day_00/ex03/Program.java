package ex03;
import java.util.Scanner;
public class Program {
    public static long GetMinValueWeekly (long value, long pow, Scanner scan) {
        int min = 10;
        int number = 0;
        for (int i = 5; i > 0; --i) {
            if (!scan.hasNextInt()) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
          number = scan.nextInt();
          if (number < 1 || number > 9) {
              System.err.println("IllegalArgument");
              System.exit(-1);
          }
          if (number < min) {
              min = number;
          }
        }
        value += min * pow;
        return  value;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String week = "";
        int number = 0;
        int counter_weeks = 1;
        long min_values_weekly = 0;
        long pow = 1;
        while (true) {
            week = scan.next();
            if ("42".equals(week) || counter_weeks == 18) break;
            if(!"Week".equals(week) || scan.nextInt() != counter_weeks) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            counter_weeks++;
            min_values_weekly = GetMinValueWeekly(min_values_weekly, pow, scan);
            pow *= 10;
        }

        for (int i = 1; i < counter_weeks; ++i) {
                long value = min_values_weekly % 10;
                min_values_weekly /= 10;
                System.out.print("Weeek " + i + " ");
                while(value > 0) {
                    System.out.print("=");
                    value--;
                }
                System.out.println(">");
            }
    }
}