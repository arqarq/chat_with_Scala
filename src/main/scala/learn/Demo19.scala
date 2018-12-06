package learn

object Demo19 {
  def main(args: Array[String]) {
    val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
    val fruit2 = "mangoes" :: ("banana" :: Nil)

    println("fruit1 ::: fruit2 : " + (fruit1 ::: fruit2))
    println("fruit1.:::(fruit2) : " + fruit1.:::(fruit2))
    println("List.concat(fruit1, fruit2, fruit2) : " + List.concat(fruit1, fruit2, fruit2))

    val additional = new Additional
    println(additional.twos)
    println(additional.fruit)
    println(additional.squares)
    println(additional.mul)
    println(additional.mul2)
  }

  class Additional {
    val twos: List[Int] = List.fill(10)(2)
    val fruit: List[String] = List.fill(3)("apple")

    val squares: List[Int] = List.tabulate[Int](6)(n => n * n)
    val mul: List[List[Int]] = List.tabulate[Int](5, 6)(_ * _)
    val mul2: List[List[Int]] = List.tabulate(5, 6)(f)

    private def f(n1: Int, n2: Int): Int = n1 * n2
  }

}
