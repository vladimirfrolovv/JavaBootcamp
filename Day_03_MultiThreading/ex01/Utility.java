package ex01;

public class Utility {
    private boolean egg_said = false;
    public synchronized void eggSay() throws InterruptedException {
        if (egg_said) {
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("Egg");
        egg_said = true;
        notify();
    }
    public synchronized void henSay() throws InterruptedException {
        if (!egg_said) {
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("Hen");
        egg_said = false;
        notify();
    }
}
