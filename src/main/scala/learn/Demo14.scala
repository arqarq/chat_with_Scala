package learn

object Demo14 {
  private val userDir = (x: Int) => {
    System.getProperty("user.dir")
    //    System.getenv()
  }

  def main(args: Array[String]) {
    println(userDir)
    //    println(userDir.apply)
    println(userDir.apply(1))
    println(System.getProperty("java.home"))
  }
}
