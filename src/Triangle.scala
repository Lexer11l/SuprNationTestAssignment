import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Triangle {

  def main(args: Array[String]): Unit = {
    readValues()
      .foldRight(List[(Int, List[Int])]())(mapLine)
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

  private def parseLine(line: String) = List(line.split(" ").map(_.toInt).toList)

  private def mapLine(cur: List[Int], prev: List[(Int, List[Int])]): List[(Int, List[Int])] = {
    cur.zipWithIndex.map {
      case (value, _) if prev.isEmpty => value -> List(value)
      case (value, i) =>
        val left = prev(i)
        val right = prev(i + 1)
        val min = if (left._1 > right._1) right else left
        value + min._1 -> (min._2 :+ value)
    }
  }

  def buildResult(value: (Int, List[Int])): String =
    value match {
      case (_, Nil) => "-1"
      case (sum, path) => s"Minimal path is ${path.reverse.mkString(sep = " + ")} = ${sum}"
    }
}

/*

7
6 3
3 8 5
11 2 10 9
EOF

 */