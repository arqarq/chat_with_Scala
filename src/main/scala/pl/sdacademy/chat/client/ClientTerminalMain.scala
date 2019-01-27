package pl.sdacademy.chat.client

import java.io.IOException

object ClientTerminalMain {
  val timeBetweenReconnectAttempt = 5
  var reconnectionAttemps = 3

  @throws(classOf[InterruptedException])
  def main(args: Array[String]): Unit = {
    println("Welcome to Awesome Chat!")
    while (reconnectionAttemps > 0) {
      try {
        println("Attempting to connect to server")
        val clientTerminal = new ClientTerminal
        val thread = new Thread(clientTerminal)
        thread.setName("Terminal")
        thread.start()
        thread.join()
        return
      } catch {
        case ex: IOException =>
          println("Could not connect to server: " + ex.getMessage)
          reconnectionAttemps = reconnectionAttemps - 1
          if (reconnectionAttemps > 0) {
            countdown(timeBetweenReconnectAttempt)
          }
      }
    }
    println("See you soon!")
  }

  @throws(classOf[InterruptedException])
  private def countdown(a: Int): Unit = {
    var i: Int = a

    while (i > 0) {
      println("### Waiting " + i + " till reconnect attempt...")
      Thread.sleep(1000)
      i = i - 1
    }
  }
}
