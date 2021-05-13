import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Triangle {

  def main(args: Array[String]): Unit = {
    print(readValues())
  }

  @tailrec
  private def readValues(triangle: List[List[Int]] = Nil) : List[List[Int]] = {
    readLine() match {
      case "EOF" | "" => triangle
      case line => readValues(triangle ++ List(line.split(" ").map(_.toInt).toList))
    }
  }
}

/*

7
6 3
3 8 5
11 2 10 9
EOF

 */