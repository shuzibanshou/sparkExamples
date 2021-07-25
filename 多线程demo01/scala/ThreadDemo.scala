import java.util.Scanner
import scala.util.control.Breaks

/**
 * 一个线程发出指令使另一个线程退出
 * scala版
 */

object ThreadDemo {
  def main(args: Array[String]): Unit = {
    val t1 = new Thread01
    val t2 = new Thread02(t1)
    t1.start()
    t2.start()
  }
}

class Thread01 extends Thread {
  private var loop:Boolean = true

  override def run(): Unit = {
    while (loop) {
      System.out.println("线程1正在运行!")
      try Thread.sleep(3000)
      catch {
        case e: InterruptedException =>
          e.printStackTrace()
      }
    }
    System.out.println("线程1已退出!")
  }

  def setLoop(b: Boolean): Unit = {
    this.loop = b
  }
}

class Thread02(val target: Thread01) extends Thread {

  private val sc = new Scanner(System.in)
  private val loop = new Breaks;

  override def run(): Unit = {
    loop.breakable{
      while (true) {
        System.out.println("请输入退出指令")
        val quit = this.sc.next.toLowerCase.charAt(0)
        if (quit == 'q') {
          target.setLoop(false)
        }
        loop.break
      }
    }
  }
}