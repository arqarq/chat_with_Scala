package learn

object Demo23 {
  def main(args: Array[String]) {
    val it = Iterator("a", "number", "of", "words")
    val ita = Iterator(20, 40, 2, 50, 69, 90)
    val itb = Iterator(20, 40, 2, 50, 69, 90)
    val itc = Iterator(20, 40, 2, 50, 69, 90)
    val itcc = Iterator(20, 40, 2, 50, 69, 90)
    val itd = Iterator(20, 40, 2, 50, 69, 90)
    val itdd = Iterator(20, 40, 2, 50, 69, 90)

    while (it.hasNext) {
      println(it.next())
    }
    println("Maximum valued element: " + ita.max)
    println("Minimum valued element: " + itb.min)
    println("Value of itc.size: " + itc.size)
    println("Value of itd.length: " + itd.length)
    val ints: Iterator[Int] = itcc ++ itdd
    println("Value of (itc ++ itd).length: " + ints.size)
    println(ita.isTraversableAgain)
  }
}
