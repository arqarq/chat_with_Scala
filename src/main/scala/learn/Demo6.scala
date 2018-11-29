package learn

object Demo6 {
  def main(args: Array[String]) {
    //    val pattern = new Regex("(S|s)cala")
//    val pattern = "[(]S|s[)]cala".r
    val pattern = "\\(S\\|\\|s\\)cala".r
    val str = "Scala is scalable and cool (S||s)cala"

    println((pattern findAllIn str).mkString(","))
  }
}
