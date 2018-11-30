package learn

object Demo11 {
  def main(args: Array[String]) {
    //    delayed(time())
    delayed(time)
  }

  //  def time() = {
  //  def time(): Long = {
  //  private def time() = {
  private def time = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  //  def delayed(t: => Long) = {
  def delayed(t: => Long): Unit = {
    println("In delayed method")
    println("Param: " + t)
  }
}
