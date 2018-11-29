package learn

object Demo7 {
  def main(args: Array[String]) {
//    val x = Demo7(5)
    val x = 7
    println(x)

    x match {
      case Demo7(num) => println(x + " is bigger two times than " + num)

      //unapply is invoked
      case _ => println("i cannot calculate")
    }
  }

  def apply(x: Int): Int = x * 2

  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}
