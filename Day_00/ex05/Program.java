package ex05;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] person_name = new String[10];
        int i = 0;
        int max_length = 0;
        for (String name = scan.next(); !".".equals(name); name = scan.next()) {
          person_name[i] = name;
          if(max_length < name.length()) {
              max_length = name.length();
          }
          i++;
        }
        int[] Class_time = new int[8];
        String[] Days_week = new String[8];


        for (; scan.hasNextInt() ;) {
            int amount = scan.nextInt();
            String day = scan.next();
         if("MO".equals(day)) {
            Class_time[7] = amount;
            Days_week[7] = day;
         } else if ("TU".equals(day)) {
             Class_time[1] = amount;
             Days_week[1] = day;
         } else if ("WE".equals(day)) {
             Class_time[2] = amount;
             Days_week[2] = day;
         } else if ("TH".equals(day)) {
             Class_time[3] = amount;
             Days_week[3] = day;
         } else if ("FR".equals(day)) {
             Class_time[4] = amount;
             Days_week[4] = day;
         } else if ("SA".equals(day)) {
             Class_time[5] = amount;
             Days_week[5] = day;
         } else if ("SU".equals(day)) {
             Class_time[6] = amount;
             Days_week[6] = day;
         }
        }
        int MAX_NUMBER_STUDENT = 10;
        int MAX_DAYS = 30;
        int MAX_CLASSES_PER_DAY = 10;
        int[][][][] visits = new int[MAX_NUMBER_STUDENT][MAX_DAYS+1][MAX_CLASSES_PER_DAY+1][1];
        String tmp = scan.next();
 for (String name = scan.next(); !".".equals(name); name = scan.next()) {
           int idx_per = getIdxPer(person_name,name);
           int time = scan.nextInt();
           int date = scan.nextInt();

           if ("HERE".equals(scan.next())) {
               visits[idx_per][date][time][0] = 1;
           } else {
               visits[idx_per][date][time][0] = -1;
           }
        }

 for (int l = 0; l < max_length; ++l) {
     System.out.print(" ");
 }

        for(int count = 0; count <= 28; count+=7) {
            for (int k = 1; k < 8; ++k) {
                if (Class_time[k] != 0) {
                    if(k+count < 31) {
                        System.out.print(Class_time[k] + ":00 ");
                        System.out.print(Days_week[k] + " ");
                        System.out.print(k + count + "|");
                    }
                }
            }
        }
        System.out.println();
        for(int j = 0; j < 10; ++j) {
            if (person_name[j] != null) {
                System.out.print(person_name[j]);
                for (int count = 0; count <= 28; count += 7) {
                    for (int k = 1; k < 8; ++k) {
                        if (Class_time[k] != 0) {
                            if (k + count < 31) {
                               if(k+count > 9) {
                                    if(visits[j][k+count][Class_time[k]][0] == 1) {
                                        System.out.print("         " + visits[j][k+count][Class_time[k]][0] + "|");
                                    } else if (visits[j][k+count][Class_time[k]][0] == -1) {
                                        System.out.print("        " + visits[j][k+count][Class_time[k]][0] + "|");
                                    }else {
                                        System.out.print("          |");
                                    }
                                } else {
                                    if (visits[j][k + count][Class_time[k]][0] == 1) {
                                        System.out.print("        " + visits[j][k + count][Class_time[k]][0] + "|");
                                    } else if (visits[j][k + count][Class_time[k]][0] == -1) {
                                        System.out.print("       " + visits[j][k + count][Class_time[k]][0] + "|");
                                    } else {
                                        System.out.print("         |");
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    public static int getIdxPer(String[] person_names, String name) {
        for (int i = 0; i < 10; ++i) {
            if ( person_names[i].equals(name)) {
                return i;
            }
        }
        return 0;
    }
}
