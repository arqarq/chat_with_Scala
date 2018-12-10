package learn

object Demo20 {
  var s1: Set[Int] = Set()
  // Set of integer type
  var s2: Set[Int] = Set(1, 3, 5, 7)
  private var s = Set(1, 3, 5, 7)

  def main(args: Array[String]): Unit = {
    println(s.head)
    println(s.tail)
    println(s.isEmpty)

    println(s2 ++ s)
    println(s2.++(s))

    println(s2.max, s2.min)

    println("s2.&(s): " + s2.&(s))
    println("s2.intersect(s): " + s2.intersect(s))
  }
}
