package learn

object Demo3 {
  def main(args: Array[String]) {
    println("Returned Value : " + addInt(5, 7))
  }

  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b

    sum
    val height = 1.9
    val name = "James"
    println(f"$name%s is $height%1.2f meters tall") //James is 1.90 meters tall
    val multiplier = (i: Int) => i * 10
    multiplier.apply(1): Int
  }
}
