package kmeshkov

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object MinTrianglePath {
  type ResultHolder = (Int, List[Int])

  private val min = (x: ResultHolder, y: ResultHolder) => if (x._1 > y._1) y else x
  private val max = (x: ResultHolder, y: ResultHolder) => if (x._1 < y._1) y else x

  def main(args: Array[String]): Unit = {
    implicit val pickOptimalFunction = if (args.headOption.contains("max")) max else min
    val acc = List[ResultHolder]()
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

  private[kmeshkov] def mapLine(cur: List[Int], prev: List[ResultHolder])
                               (implicit pickOptimal: (ResultHolder, ResultHolder) => ResultHolder) =
    cur.zipWithIndex.map {
      case (value, _) if prev.isEmpty => value -> List(value)
      case (value, i) =>
        pickOptimal(prev(i + 1), prev(i)) match {
          case (prevVal, path) => value + prevVal -> (value +: path)
        }
    }

  private[kmeshkov] def buildResult(result: ResultHolder) = result match {
    case (_, Nil) => "-1"
    case (sum, path) => s"Minimal path is ${path.mkString(sep = " + ")} = $sum"
  }
}
