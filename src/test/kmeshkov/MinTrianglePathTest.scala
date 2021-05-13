package kmeshkov

object MinTrianglePathTest {

  def main(args: Array[String]): Unit = {
    testParseTwoValues()
    testParseOneValue()
    testBuildValidResult()
    testBuildEmptyPathResult()
  }

  def testParseTwoValues(): Unit = {
    println(s"testParseTwoValues is ${equals(List(List(7, 8)), MinTrianglePath.parseLine("7 8"))}")
  }

  def testParseOneValue(): Unit = {
    println(s"testParseOneValue is ${equals(List(List(7)), MinTrianglePath.parseLine("7"))}")
  }

  def testBuildValidResult(): Unit = {
    println(s"testBuildValidResult is ${equals("Minimal path is 5 + 6 + 7 = 18", MinTrianglePath.buildResult(18, List(7, 6, 5)))}")
  }

  def testBuildEmptyPathResult(): Unit = {
    println(s"testBuildEmptyPathResult is ${equals("-1", MinTrianglePath.buildResult(18, Nil))}")
  }

  private def equals[T](expected: T, actual: T): String = {
    if (expected == actual) "Successful" else s"Failed.\nShould be $expected, but got $actual"
  }
}
