
/**
 * 多线程防止超卖问题
 * java版
 */

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadExercise tExercise = new ThreadExercise();

        Thread t1 = new Thread(tExercise);
        t1.start();
        Thread t2 = new Thread(tExercise);
        t2.start();
    }
}

class ThreadExercise implements Runnable{

    private int money = 100;
    private Object obj = new Object();

    public void run() {

        while (true){
            synchronized (obj) {
                if (money <= 0) {
                    System.out.println("商品已卖完");
                    break;
                } else {
                    money -= 10;
                }
                System.out.println("当前存货:" + money);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}


