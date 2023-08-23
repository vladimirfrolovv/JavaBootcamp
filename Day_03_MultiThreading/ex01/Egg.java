package ex01;

public class Egg extends Thread{
        private final int count;
        private Utility utility;
        @Override
        public  void run () {
            for (int i = 0 ; i < count; ++i) {
                try {
                    utility.eggSay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public Egg(int count, Utility utility ) {
            this.count = count;
            this.utility = utility;
        }
    }
