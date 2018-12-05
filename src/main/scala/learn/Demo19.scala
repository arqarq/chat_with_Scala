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
  }

  class Additional {
    val twos: List[Int] = List.fill(10)(2)
    val fruit: List[String] = List.fill(3)("apple")
  }

}
