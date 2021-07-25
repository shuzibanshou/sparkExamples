
import java.util.Scanner;


/**
 * 一个线程发出指令使另一个线程退出
 * java版
 */

/*
public class ThreadDemo {
    public static void main(String[] args) {
        Thread01 t1 = new Thread01();
        Thread02 t2 = new Thread02(t1);
        t1.start();
        t2.start();
    }
}

class Thread01 extends Thread{
    private boolean loop = true;

    @Override
    public void run() {
        while (loop){
            System.out.println("线程1正在运行!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程1已退出!");
    }

    public void setLoop(boolean b){
        this.loop = b;
    }

}

class Thread02 extends Thread{
    private Thread01 target = null;
    private Scanner sc = new Scanner(System.in);

    public  Thread02(Thread01 obj){
        if(obj != null) {
            this.target = obj;
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入退出指令");
            char quit = this.sc.next().toLowerCase().charAt(0);
            if(quit == 'q'){
                target.setLoop(false);
            }
            break;
        }
    }
}*/
