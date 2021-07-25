import scala.util.control.Breaks

/**
 * 多线程防止超卖问题
 * scala版
 */
object ThreadDemo {
  def main(args: Array[String]): Unit = {
    val tExercise = new ThreadExercise()
    val t1 = new Thread(tExercise)
    t1.start()
    val t2 = new Thread(tExercise)
    t2.start()
  }
}

class ThreadExercise extends Runnable {
  private var money = 100
  private val obj = new Object()
  private val loop = new Breaks

  override def run(): Unit = {
    loop.breakable {
      while (true) {
        obj.synchronized {
          if (money <= 0) {
            System.out.println("商品已卖完")
            loop.break
          } else {
            money -= 10
          }
          System.out.println("当前存货:" + money)
        }
        try {
          Thread.sleep(500)
        } catch {
          case e: InterruptedException => e.printStackTrace()
        }
      }
    }
  }
}


