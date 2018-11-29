package learn

import scala.io.StdIn

object Demo9 {
  def main(args: Array[String]) {
    print("Please enter your input: ")
    //    val line = Console.readLine()
    val line = StdIn.readLine()

    println("Thanks, you just typed: " + line)
  }
}
