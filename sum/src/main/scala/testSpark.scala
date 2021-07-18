
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, TaskContext}

object testSpark {
  def main(args: Array[String]): Unit = {
    val sparkConf  = new SparkConf().setAppName("sparkTest").setMaster("local[*]")    //"spark://192.168.3.221:7077"
    val sc = new SparkContext(sparkConf)
    val rdd:RDD[String] = sc.textFile("./testTextFile/*")
    val rdd1:RDD[Int] = rdd.flatMap(_.split(',')).map(_.toInt)
    val res = rdd1.sum()
    println(res)
  }
}
