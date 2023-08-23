package ex01;

public class Program {


    public static void main ( String[] args ) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Input valid data --count=(your value)");
            System.exit(-1);
        }
        int count = Integer.parseInt(args[0].substring("--count=".length()));

        if (count <= 0) {
            System.out.println("Invalid count: " + count);
            System.exit(-1);
        }
        Utility utility = new Utility();
        Egg egg = new Egg(count, utility);
       Hen hen = new Hen(count,utility);
       egg.start();
       hen.start();



    }
}
