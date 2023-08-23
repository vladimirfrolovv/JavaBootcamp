package ex02;

public class SumThread extends Thread{
        private final int from;
        private final int to;
        public SumThread(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public void run () {
            Program.sum = 0;
            for (int i = from; i <= to; i++) {
                if(i < Program.array.length)
                    Program.sum += Program.array[i];
            }
            if (Program.sum != 0)  {
                System.out.printf("Thread %d: from %d to %d sum is %d\n",Program.current_thread, from, to, Program.sum);
                Program.current_thread++;
            }

        }
    }


