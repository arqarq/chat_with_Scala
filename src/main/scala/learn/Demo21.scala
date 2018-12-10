package learn

object Demo21 {
  val capitals: Map[String, String] = Map("France" -> "Paris", "Japan" -> "Tokyo")

  def main(args: Array[String]): Unit = {
    println("capitals.get(\"France\"): " + capitals.get("France"))
    println("capitals.get(\"India\"): " + capitals.get("India"))

    println("capitals.get(\"France\"): " + show(capitals.get("France")))
    println("capitals.get(\"India\"): " + show2(capitals.get("India")))

    val a: Option[Int] = Some(5)
    val b: Option[Int] = None

    println("a.getOrElse(0): " + a.getOrElse(0))
    println("b.getOrElse(10): " + b.getOrElse(10))
    println("a.isEmpty: " + a.isEmpty)
    println("b.isEmpty: " + b.isEmpty)

    println(vowelsInString("United States"))
  }

  def vowelsInString(string: String): Set[Char] = {
    val isVowel = Set('a', 'e', 'i', 'o', 'u', 'U', 's', 'S')

    def d(x: Char): Boolean = {
      true
    }

    val str: String = string.filter(d)

    println(str.count(isVowel))
    str.filter(isVowel).toSet
  }

  def show(x: Option[String]): String = {
    x.getOrElse("?")
  }

  def show2(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }
}
