package learn

object Demo13 {
  def main(args: Array[String]) {
    println(applyy(layoutt, 10))
  }

  private def applyy(f: Int => String, v: Int) = f(v)

  private def layoutt[A](x: A) = "[" + x.toString + "]"
}
