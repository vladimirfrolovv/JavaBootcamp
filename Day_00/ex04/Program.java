package ex04;
import java.util.Scanner;
public class Program {
    public static void Print(char[] arr_let, int[] arr_num, int count_let) {
        int max_value = arr_num[0];
        System.out.println();
        for(int i = 0; i < 10; ++i) {
            if (arr_num[i] == max_value) {
                System.out.print(max_value + "    ");
            }
        }
        System.out.println();
        for (int i = 10; i > 0; --i) {
            for (int j = 0; j < 10; ++j) {
                if (arr_num[j] * 10 / max_value >= i)
                    System.out.print("#    ");
                if (arr_num[j] * 10 / max_value == i - 1) {
                    if (arr_num[j] != 0)
                        System.out.print(arr_num[j] + "    ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < count_let; ++i) {
            System.out.print((char)arr_let[i] + "    ");
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (line.length() < 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        char[] line_ar = line.toCharArray();
        int[] letters = new int[65535];
        for (char elem : line_ar) {
            letters[elem]++;
        }
        int count_let = 0;
        int max_num = 0;
        char max_let = ' ';
        int[] res_num = new int[10];
        char[] res_let = new char[10];
        int id_x = 0;
        int j = 0;
        for (int i = 0; i < 10; ++i) {
            for (; j < 65535; ++j) {
                if(max_num < letters[j]) {
                    max_num = letters[j];
                    max_let = (char)j;
                    id_x = j;
                }
            }
            res_num[i] = max_num;
            res_let[i] = max_let;
            letters[id_x] = 0;
            if (max_num != 0) {
                count_let++;
            }
            max_num = 0;
            j = 0;

        }
        Print(res_let, res_num, count_let);

    }
}