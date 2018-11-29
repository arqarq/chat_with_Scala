package learn

import scala.io.Source

object Demo10 {
  def main(args: Array[String]) {
    println("Following is the content read:")

    Source.fromFile("Demo.txt").foreach {
      print
    }
  }
}
