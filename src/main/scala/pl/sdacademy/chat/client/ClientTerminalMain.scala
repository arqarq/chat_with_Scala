package pl.sdacademy.chat.client

object ClientTerminalMain {
  @throws(classOf[InterruptedException])
  def main(args: Array[String]): Unit = {
    val thread = new ClientTerminal
    thread.setName("Terminal")
    thread.start()
    thread.join()
  }
}
