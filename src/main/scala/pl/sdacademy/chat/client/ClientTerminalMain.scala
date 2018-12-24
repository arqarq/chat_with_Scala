package pl.sdacademy.chat.client

object ClientTerminalMain {
  val timeBetweenReconnectAttempt = 5
  var reconnectionAttemps = 3

  @throws(classOf[InterruptedException])
  def main(args: Array[String]): Unit = {
    val thread = new ClientTerminal
    thread.setName("Terminal")
    thread.start()
    thread.join()
  }
}
