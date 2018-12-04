package learn

object Demo16 {
  def main(args: Array[String]) {
    val str1: String = "Hello, "
    val str2: String = "Scala!"
    val str3: String = " Hello!"

    println("str1 + str2 + str3 = " + strcat(str1)(str2)(str3))
    println("str1 + str2 = " + strcat2(str1)(str2))
  }

  def strcat(s1: String)(s2: String)(s3: String): String = {
    s1 + s2 + s3
  }

  def strcat2(s1: String): String => String = (s2: String) => s1 + s2
}
