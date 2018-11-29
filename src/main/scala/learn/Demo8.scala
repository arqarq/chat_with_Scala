package learn

import java.io.{File, PrintWriter}

object Demo8 {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("Demo.txt"))

    writer.write("Hello Scala")
    writer.close()
  }
}
