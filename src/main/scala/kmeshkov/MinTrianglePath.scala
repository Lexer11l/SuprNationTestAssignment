package kmeshkov

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object MinTrianglePath {

  private val min = (x: (Int, List[Int]), y: (Int, List[Int])) => if (x._1 > y._1) y else x
  private val max = (x: (Int, List[Int]), y: (Int, List[Int])) => if (x._1 < y._1) y else x

  def main(args: Array[String]): Unit = {
    implicit val compare1 = if (args.headOption.contains("max")) max else min
    val acc = List[(Int, List[Int])]()
    readValues()
      .foldRight(acc)(mapLine)
      .map(buildResult)
      .foreach(println)
  }

  @tailrec
  private def readValues(triangle: List[List[Int]] = Nil): List[List[Int]] = {
    readLine() match {
      case "EOF" | "" => triangle
      case line => readValues(triangle ++ parseLine(line))
    }
  }

  private[kmeshkov] def parseLine(line: String) = List(line.split(" ").map(_.toInt).toList)

  private[kmeshkov] def mapLine(cur: List[Int], prev: List[(Int, List[Int])])
                               (implicit compare: ((Int, List[Int]), (Int, List[Int])) => (Int, List[Int])) =
    cur.zipWithIndex.map {
      case (value, _) if prev.isEmpty => value -> List(value)
      case (value, i) =>
        compare(prev(i + 1), prev(i)) match {
          case (prevVal, path) => value + prevVal -> (path :+ value)
        }
    }

  private[kmeshkov] def buildResult(value: (Int, List[Int])) = value match {
    case (_, Nil) => "-1"
    case (sum, path) => s"Minimal path is ${path.reverse.mkString(sep = " + ")} = $sum"
  }
}
