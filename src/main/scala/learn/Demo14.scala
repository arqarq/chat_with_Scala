package learn

object Demo14 {
  private val userDir = () => {
    System.getenv("JAVA_HOME")
  }

  def main(args: Array[String]) {
    println(userDir)
  }
}
