package ex01;

public class Hen extends Thread {
    private final int count;
    private Utility utility;
    @Override
    public void run () {
            for (int i = 0 ; i < count; ++i) {
                try {
                    utility.henSay();
                } catch (InterruptedException e) {
                    e.getMessage();
                }

            }
        }
    public Hen(int count, Utility utility ) {
        this.count = count;
        this.utility = utility;
    }
}
