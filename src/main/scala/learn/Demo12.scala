package learn

object Demo12 {
  def main(args: Array[String]) {
    printInt(5, 7)
    println()
    printInt(b = 5, a = 7)
  }

  def printInt(a: Int, b: Int): Unit = {
    println("Value of a: " + a)
    println("Value of b: " + b)
  }
}
